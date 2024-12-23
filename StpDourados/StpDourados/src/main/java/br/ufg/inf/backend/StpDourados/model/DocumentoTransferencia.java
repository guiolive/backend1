package br.ufg.inf.backend.StpDourados.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class DocumentoTransferencia {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<MedicamentoPrescrito> drogasAdministradas;

    @ElementCollection
    private List<String> procedimentosAcondicionamento;

    @ElementCollection
    private List<String> procedimentosRecebimento;

}
