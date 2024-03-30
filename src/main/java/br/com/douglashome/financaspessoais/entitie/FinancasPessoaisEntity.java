package br.com.douglashome.financaspessoais.entitie;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tab_fin_pesso")
public class FinancasPessoaisEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "tp_gasto", nullable = false, length = 500)
	private String tpGasto;

	@Column(name = "custo", nullable = false, length = 500)
	private Double custo;

	@Column(name = "data", nullable = false, length = 500)
	private Date data;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTpGasto() {
		return tpGasto;
	}

	public void setTpGasto(String tpGasto) {
		this.tpGasto = tpGasto;
	}

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
