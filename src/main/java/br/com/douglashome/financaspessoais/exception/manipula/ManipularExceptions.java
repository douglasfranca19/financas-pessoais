package br.com.douglashome.financaspessoais.exception.manipula;

import java.time.Instant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.douglashome.financaspessoais.dto.ErrorDto;
import br.com.douglashome.financaspessoais.exception.Inst.IdNotFound;
import br.com.douglashome.financaspessoais.exception.Inst.TpGastoFora;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ManipularExceptions {

	@ExceptionHandler(IdNotFound.class)
	public ResponseEntity<ErrorDto> idnotfound(IdNotFound e, HttpServletRequest request) {

		ErrorDto error = new ErrorDto(Instant.now(), 404, "Erro ao realizar a busca com os dados informados.",
				request.getRequestURI(), e.getMessage());

		return ResponseEntity.status(404).body(error);
	}

	@ExceptionHandler(TpGastoFora.class)
	public ResponseEntity<ErrorDto> tpgastofora(TpGastoFora e, HttpServletRequest request) {

		ErrorDto error = new ErrorDto(Instant.now(), 401, "Erro ao realizar a busca com os dados informados.",
				request.getRequestURI(), e.getMessage());

		return ResponseEntity.status(401).body(error);
	}

}
