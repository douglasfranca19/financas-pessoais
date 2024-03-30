package br.com.douglashome.financaspessoais.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.douglashome.financaspessoais.entitie.FinancasPessoaisEntity;
import br.com.douglashome.financaspessoais.service.FinancasPessoaisService;

@RestController
@RequestMapping(value = "/financas-pessoais")
public class FinancasPessoaisController {

	@Autowired
	private FinancasPessoaisService pessoaisService;

	@GetMapping(value = "/list-all-financas")
	public ResponseEntity<List<FinancasPessoaisEntity>> listAllFinancas() {
		return ResponseEntity.ok().body(pessoaisService.listAllFinancas());
	}

}