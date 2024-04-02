package br.com.douglashome.financaspessoais.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.douglashome.financaspessoais.entitie.FinancasPessoaisEntity;

@Repository
public interface FinancasPessoaisRepository extends JpaRepository<FinancasPessoaisEntity, Long> {

	@Query(value = "SELECT * FROM tab_fin_pesso WHERE tp_gasto = ?1", nativeQuery = true)
	List<FinancasPessoaisEntity> buscaTpGasto(String tpGasto);
	
	@Query(value = "SELECT * FROM tab_fin_pesso WHERE data between ?1 and ?2", nativeQuery = true)
	List<FinancasPessoaisEntity> buscaDate(Date dtInicial, Date dtFinal);

	@Query(value = "SELECT * FROM tab_fin_pesso WHERE tp_gasto = ?1 AND data between ?2 and ?3", nativeQuery = true)
	List<FinancasPessoaisEntity> buscaTpGastoAndDate(String tpGasto, Date dtInicial, Date dtFinal);
}
