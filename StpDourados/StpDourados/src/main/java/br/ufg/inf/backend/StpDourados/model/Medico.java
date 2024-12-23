package br.ufg.inf.backend.StpDourados.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Medico {
	@Id
    @Column(length = 10, nullable = false, unique = true)
    private String crm;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 20)
    private String telefone;

    @ManyToOne(optional = false)
    @JoinColumn(name = "unidade_hospitalar_id", nullable = false)
    private UnidadeHospitalar unidadeHospitalar;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Papel papel;

    @ManyToOne(optional = false)
    @JoinColumn(name = "especialidade_id", nullable = false)
    private Especialidade especialidade;

}
