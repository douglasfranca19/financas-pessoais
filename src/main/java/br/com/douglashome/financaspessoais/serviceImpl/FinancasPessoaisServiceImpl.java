package br.com.douglashome.financaspessoais.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.douglashome.financaspessoais.entitie.FinancasPessoaisEntity;
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
	public FinancasPessoaisEntity insertGastos(FinancasPessoaisEntity pessoaisEntity) {
		return pessoaisRepository.save(pessoaisEntity);
	}

}
