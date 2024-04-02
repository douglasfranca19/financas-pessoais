package br.com.douglashome.financaspessoais.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.douglashome.financaspessoais.entitie.FinancasPessoaisEntity;
import br.com.douglashome.financaspessoais.exception.Inst.IdNotFound;
import br.com.douglashome.financaspessoais.exception.Inst.TpGastoFora;
import br.com.douglashome.financaspessoais.repository.FinancasPessoaisRepository;
import br.com.douglashome.financaspessoais.service.FinancasPessoaisService;

@Service
public class FinancasPessoaisServiceImpl implements FinancasPessoaisService {

	@Autowired
	private FinancasPessoaisRepository pessoaisRepository;

	@Override
	public List<FinancasPessoaisEntity> listAllFinancas() {
		return pessoaisRepository.findAll();
	}

	@Override
	public Optional<FinancasPessoaisEntity> listId(Long id) {

		Optional<FinancasPessoaisEntity> pEntity = pessoaisRepository.findById(id);

		if (pEntity.isEmpty()) {
			throw new IdNotFound("Id não encontrado na base de dados");
		}

		return pEntity;
	}

	@Override
	public FinancasPessoaisEntity insertGastos(FinancasPessoaisEntity pessoaisEntity) {

		if (pessoaisEntity.getTpGasto().equals("Lazer") || pessoaisEntity.getTpGasto().equals("Visual")
				|| pessoaisEntity.getTpGasto().equals("Contas") || pessoaisEntity.getTpGasto().equals("Poupança")) {

			pessoaisEntity = pessoaisRepository.save(pessoaisEntity);

			return pessoaisEntity;

		}

		throw new TpGastoFora("Tipo gasto não autorizado. Tipos disponíveis: Lazer, Visual, Contas ou Poupança");

	}

	@Override
	public List<FinancasPessoaisEntity> buscaTpGasto(String tpGasto) {

		List<FinancasPessoaisEntity> pessoaisEntity = pessoaisRepository.buscaTpGasto(tpGasto);

		if (pessoaisEntity.isEmpty()) {
			throw new TpGastoFora("Tipo gasto não autorizado. Tipos disponíveis: Lazer, Visual, Contas ou Poupança");
		}

		return pessoaisEntity;
	}

	@Override
	public List<FinancasPessoaisEntity> buscaTpGastoAndDate(String tpGasto, Date dtInicial, Date dtFinal) {

		List<FinancasPessoaisEntity> pessoaisEntity = pessoaisRepository.buscaTpGastoAndDate(tpGasto, dtInicial,
				dtFinal);

		if (pessoaisEntity.isEmpty()) {
			throw new TpGastoFora("Tipo gasto ou data não encontrados na base de dados, favor tentar novamente.");
		}

		return pessoaisEntity;
	}

	@Override
	public List<FinancasPessoaisEntity> buscaDate(Date dtInicial, Date dtFinal) {

		List<FinancasPessoaisEntity> pessoaisEntity = pessoaisRepository.buscaDate(dtInicial, dtFinal);

		if (pessoaisEntity.isEmpty()) {
			throw new TpGastoFora(
					"Registros não encontrados encontrados na base de dados pelas datas informadas, favor tentar novamente.");
		}

		return pessoaisEntity;
	}

	@Override
	public List<FinancasPessoaisEntity> listAllFinancasSoma() {

		List<FinancasPessoaisEntity> pessoaisEntity = pessoaisRepository.findAll();

		Double sum = 0.0;
		
		for (int i =0; i < pessoaisEntity.size(); i += pessoaisEntity.get(0).getCusto()) {
			
			sum += i;
		}
		
		return pessoaisEntity;

	}

}
