package br.ufg.inf.backend.StpDourados.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@lombok.Getter
@lombok.Setter
@Entity
public class UnidadeHospitalar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String telefone;
	private String email;
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;
	private String dadosPessoal;
	private Double latitude;
	private Double longitude;
	private Integer disponibilidadeLeitos;
	private boolean temUTI;
	@ManyToMany
	private List<Especialidade> especialidades;

	public UnidadeHospitalar() {
	}

	public UnidadeHospitalar(String telefone, String email, Endereco endereco, String dadosPessoal, Double latitude,
			Double longitude, Integer disponibilidadeLeitos, boolean temUTI, List<Especialidade> especialidades) {
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.dadosPessoal = dadosPessoal;
		this.latitude = latitude;
		this.longitude = longitude;
		this.disponibilidadeLeitos = disponibilidadeLeitos;
		this.temUTI = temUTI;
		this.especialidades = especialidades;
	}
}
