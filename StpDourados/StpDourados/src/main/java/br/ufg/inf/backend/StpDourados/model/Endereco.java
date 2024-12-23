package br.ufg.inf.backend.StpDourados.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@lombok.Getter
@lombok.Setter
@Entity
public class Endereco {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String rua;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;

    public Endereco() {}

    public Endereco(String cep, String rua, String complemento, String bairro, String cidade, String estado) {
        this.cep = cep;
        this.rua = rua;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }
    
}
