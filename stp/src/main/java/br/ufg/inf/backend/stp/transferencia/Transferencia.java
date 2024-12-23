package br.ufg.inf.backend.stp.transferencia;

import java.util.Date;

import br.ufg.inf.backend.stp.unidade_hospitalar.UnidadeHospitalar;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Transferencia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "meio_transporte", length = 20)
	private MeioTransporte meioTransporte;
	
	@ManyToOne
	@JoinColumn(name = "destino_id")
	private UnidadeHospitalar destino;
	
	@ManyToOne
	@JoinColumn(name = "origem_id")
	private UnidadeHospitalar origem;

	private Date horarioSaida;
	private Date horarioPrevistoChegada;
	private Double distancia;
}
