package br.ufg.inf.backend.StpDourados.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Solicitacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Medico medico;

	@ManyToOne
	private Paciente paciente;
	private String motivo;

	@ManyToOne
	private DocumentoTransferencia documento;

	@ManyToMany
	private List<Especialidade> especialidadesRequisitadas;
	private Date horarioSolicitacao;
}
