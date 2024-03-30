package br.com.douglashome.financaspessoais.serviceImpl;

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

		throw new TpGastoFora(
				"Tipo gasto não autorizado para insert. Tipos disponíveis: Lazer, Visual, Contas ou Poupança");

	}

}
