package br.com.douglashome.financaspessoais.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.douglashome.financaspessoais.dto.FinancasPessoaisEntradaDto;
import br.com.douglashome.financaspessoais.entitie.FinancasPessoaisEntity;
import br.com.douglashome.financaspessoais.service.FinancasPessoaisService;

@RestController
@RequestMapping(value = "/financas-pessoais")
public class FinancasPessoaisController {

	@Autowired
	private FinancasPessoaisService pessoaisService;

	@PostMapping(value = "/insere-gasto")
	public ResponseEntity<FinancasPessoaisEntity> insertGastos(
			@RequestBody FinancasPessoaisEntradaDto pessoaisEntradaDto) {

		FinancasPessoaisEntity pessoaisEntity = new FinancasPessoaisEntity();

		pessoaisEntity.setTpGasto(pessoaisEntradaDto.getTpGasto());
		pessoaisEntity.setCusto(pessoaisEntradaDto.getCusto());
		pessoaisEntity.setData(pessoaisEntradaDto.getData());

		return ResponseEntity.ok().body(pessoaisService.insertGastos(pessoaisEntity));

	}

	@GetMapping(value = "/list-all-financas")
	public ResponseEntity<List<FinancasPessoaisEntity>> listAllFinancas() {
		return ResponseEntity.ok().body(pessoaisService.listAllFinancas());
	}

	@GetMapping(value = "/list-id-financas/{id}")
	public ResponseEntity<Optional<FinancasPessoaisEntity>> listId(@PathVariable Long id) {
		return ResponseEntity.ok().body(pessoaisService.listId(id));
	}

	@GetMapping(value = "/list-tp-gasto/{tpGasto}")
	public ResponseEntity<List<FinancasPessoaisEntity>> buscaTpGasto(@PathVariable String tpGasto) {
		return ResponseEntity.ok().body(pessoaisService.buscaTpGasto(tpGasto));
	}

	@GetMapping(value = "/list-data/{dtInicial}/{dtFinal}")
	public ResponseEntity<List<FinancasPessoaisEntity>> buscaDate(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dtInicial,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dtFinal) {

		return ResponseEntity.ok().body(pessoaisService.buscaDate(dtInicial, dtFinal));

	}

	@GetMapping(value = "/list-tp-gasto-data/{tpGasto}/{dtInicial}/{dtFinal}")
	public ResponseEntity<List<FinancasPessoaisEntity>> buscaTpGastoAndDate(@PathVariable String tpGasto,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dtInicial,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dtFinal) {

		return ResponseEntity.ok().body(pessoaisService.buscaTpGastoAndDate(tpGasto, dtInicial, dtFinal));

	}

}
