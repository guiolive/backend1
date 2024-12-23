package br.ufg.inf.backend.StpDourados.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Transferencia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String meioTransporte;

	@ManyToOne
	private UnidadeHospitalar destino;

	@ManyToOne
	private Medico medicoDestino;

	@ManyToOne
	private UnidadeHospitalar origem;

	@ManyToOne
	private Medico medicoOrigem;

	@ManyToOne
	private Medico medicoRegulador;
	private Date horarioSaida;
	private Date horarioPrevistoChegada;
	private Double distancia;

	@ManyToOne
	private DocumentoTransferencia documento;

	@ManyToOne
	private Paciente paciente;

	@ManyToOne
	private Solicitacao solicitacao;
}
