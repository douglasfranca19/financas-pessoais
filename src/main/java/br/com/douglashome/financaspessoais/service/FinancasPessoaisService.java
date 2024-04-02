package br.com.douglashome.financaspessoais.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import br.com.douglashome.financaspessoais.entitie.FinancasPessoaisEntity;

public interface FinancasPessoaisService {

	List<FinancasPessoaisEntity> listAllFinancas();

	public FinancasPessoaisEntity insertGastos(FinancasPessoaisEntity pessoaisEntity);

	Optional<FinancasPessoaisEntity> listId(Long id);

	List<FinancasPessoaisEntity> buscaTpGasto(String tpGasto);

	List<FinancasPessoaisEntity> buscaTpGastoAndDate(String tpGasto, Date dtInicial, Date dtFinal);

	List<FinancasPessoaisEntity> buscaDate(Date dtInicial, Date dtFinal);

	List<FinancasPessoaisEntity> listAllFinancasSoma();

}
