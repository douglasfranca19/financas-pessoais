package br.com.douglashome.financaspessoais.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.douglashome.financaspessoais.entitie.FinancasPessoaisEntity;

@Repository
public interface FinancasPessoaisRepository extends JpaRepository<FinancasPessoaisEntity, Long> {

}
