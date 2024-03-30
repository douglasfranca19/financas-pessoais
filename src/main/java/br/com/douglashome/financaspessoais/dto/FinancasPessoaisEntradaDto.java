package br.com.douglashome.financaspessoais.dto;

import java.util.Date;

public class FinancasPessoaisEntradaDto {

	private String tpGasto;
	private Date data;
	private Double custo;
	private Double saldo;

	public FinancasPessoaisEntradaDto() {
	}

	public FinancasPessoaisEntradaDto(String tpGasto, Date data, Double custo, Double saldo) {
		this.tpGasto = tpGasto;
		this.data = data;
		this.custo = custo;
		this.saldo = saldo;
	}

	public String getTpGasto() {
		return tpGasto;
	}

	public void setTpGasto(String tpGasto) {
		this.tpGasto = tpGasto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

}
