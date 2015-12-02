package com.fredcar.veiculos.domino;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tab_veiculo")
public class Veiculo {

	private Long codigo;//identificador único do veículo. Chave Primária.
	private String fabricante;//nome do fabricante do veículo.
	private String modelo;//descrição do modelo do veículo.
	private Integer anoFabricacao;//número do ano de fabricação do veículo.
	private Integer anoModelo;//número do ano do modelo do veículo.
	private BigDecimal valor;//valor que está sendo pedido para venda do veículo.
	private String opcional;//apetrechos amais do veículo.
	
	@Id
	@GeneratedValue
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	@Column(length = 60, nullable = false)
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
	@Column(length = 60, nullable = false)
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	@Column(name="ano_fabricacao", nullable= false)
	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	
	@Column(name="ano_modelo", nullable= false)
	public Integer getAnoModelo() {
		return anoModelo;
	}
	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}
	
	@Column(precision = 10, scale = 2, nullable= false)
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	@Column(length = 90, nullable = false)
	public String getOpcional() {
		return opcional;
	}
	public void setOpcional(String opcional) {
		this.opcional = opcional;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		final Veiculo other = (Veiculo) obj;
		
		if(codigo == null){
			if(other.codigo != null)
				return false;
			
		} else if (!codigo.equals(other.codigo))
			return false;
		return true; 
	}
	
}
