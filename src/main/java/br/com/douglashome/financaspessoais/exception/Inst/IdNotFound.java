package br.com.douglashome.financaspessoais.exception.Inst;

public class IdNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IdNotFound(String mensagem) {
		super(mensagem);
	}
}
