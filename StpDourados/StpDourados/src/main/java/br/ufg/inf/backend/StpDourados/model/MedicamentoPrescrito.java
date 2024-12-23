package br.ufg.inf.backend.StpDourados.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@lombok.Getter
@lombok.Setter
@Entity
public class MedicamentoPrescrito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Medicamento medicamento;
	private String posologia;
	private Double dosagem;
	private String unidadeDosagem;
	private String viaAdministracao;

	public MedicamentoPrescrito() {
	}

	public MedicamentoPrescrito(Medicamento medicamento, String posologia, Double dosagem, String unidadeDosagem,
			String viaAdministracao) {
		this.medicamento = medicamento;
		this.posologia = posologia;
		this.dosagem = dosagem;
		this.unidadeDosagem = unidadeDosagem;
		this.viaAdministracao = viaAdministracao;
	}
}
