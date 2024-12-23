package br.ufg.inf.backend.stp.endereco;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String rua;
	private String complemento;
	private String bairro;
	private String cep;
	private String cidade;
	private String estado;
}
