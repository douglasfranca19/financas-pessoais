package br.com.douglashome.financaspessoais.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class FinancasPessoaisEntradaDto {

	private String tpGasto;
	private Date data;

	private Double custo;

	public FinancasPessoaisEntradaDto() {
	}

	public FinancasPessoaisEntradaDto(String tpGasto, Date data, Double custo) {
		this.tpGasto = tpGasto;
		this.data = data;
		this.custo = custo;
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

}
