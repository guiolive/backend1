package br.ufg.inf.backend.produto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//Request -> Controller -> Service -> Repository -> Spring Data -> Hibernate -> H2BD
@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduto;
	private String nomeProduto;
	private double precoProduto;

	public Produto(Long idProduto, String nomeProduto, double precoProduto) {
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.precoProduto = precoProduto;

	}

	public Produto() {

	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public double getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(double precoProduto) {
		this.precoProduto = precoProduto;
	}

}
