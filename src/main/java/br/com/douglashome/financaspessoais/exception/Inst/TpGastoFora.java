package br.com.douglashome.financaspessoais.exception.Inst;

public class TpGastoFora extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TpGastoFora(String mensagem) {
		super(mensagem);
	}
}
