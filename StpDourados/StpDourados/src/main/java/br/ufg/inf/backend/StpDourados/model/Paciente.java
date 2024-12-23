package br.ufg.inf.backend.StpDourados.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Paciente {
	@Id
	@Column(length = 11, nullable = false, unique = true)
	private String cpf;

	@Column(length = 100, nullable = false)
	private String nome;

	@Column(length = 20, nullable = false)
	private String telefone;

	@Column(length = 100, nullable = false)
	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	@Enumerated(EnumType.STRING)
	@Column(length = 12, nullable = false)
	private TipoSanguineo tipoSanguineo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "prontuario_id")
	private Prontuario prontuario;

	
}
