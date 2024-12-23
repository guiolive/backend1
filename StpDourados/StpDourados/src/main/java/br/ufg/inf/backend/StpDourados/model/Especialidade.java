package br.ufg.inf.backend.StpDourados.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@lombok.Getter
@lombok.Setter
@Entity
public class Especialidade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;

	public Especialidade() {
	}

	public Especialidade(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}
}
