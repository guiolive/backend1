package br.ufg.inf.backend.StpDourados.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@lombok.Getter
@lombok.Setter
@Entity
public class Medicamento {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String principioAtivo;
    private String descricao;

    public Medicamento() {}

    public Medicamento(String nome, String principioAtivo, String descricao) {
        this.nome = nome;
        this.principioAtivo = principioAtivo;
        this.descricao = descricao;
    }
}
