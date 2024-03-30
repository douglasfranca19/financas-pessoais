package br.com.douglashome.financaspessoais.service;

import java.util.List;
import java.util.Optional;

import br.com.douglashome.financaspessoais.entitie.FinancasPessoaisEntity;

public interface FinancasPessoaisService {

	List<FinancasPessoaisEntity> listAllFinancas();

	public FinancasPessoaisEntity insertGastos(FinancasPessoaisEntity pessoaisEntity);

	Optional<FinancasPessoaisEntity> listId(Long id);
}
