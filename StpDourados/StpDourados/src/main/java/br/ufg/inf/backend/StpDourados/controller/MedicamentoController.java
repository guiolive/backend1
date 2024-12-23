package br.ufg.inf.backend.StpDourados.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufg.inf.backend.StpDourados.model.Medicamento;
import br.ufg.inf.backend.StpDourados.repository.MedicamentoRepository;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    @GetMapping
    public List<Medicamento> getAllMedicamentos() {
        return medicamentoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicamento> getMedicamentoById(@PathVariable Long id) {
        Optional<Medicamento> medicamento = medicamentoRepository.findById(id);
        return medicamento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Medicamento createMedicamento(@RequestBody Medicamento medicamento) {
        return medicamentoRepository.save(medicamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medicamento> updateMedicamento(@PathVariable Long id, @RequestBody Medicamento medicamentoDetails) {
        Optional<Medicamento> optionalMedicamento = medicamentoRepository.findById(id);

        if (optionalMedicamento.isPresent()) {
            Medicamento medicamento = optionalMedicamento.get();
            medicamento.setNome(medicamentoDetails.getNome());
            medicamento.setPrincipioAtivo(medicamentoDetails.getPrincipioAtivo());
            medicamento.setDescricao(medicamentoDetails.getDescricao());

            Medicamento updatedMedicamento = medicamentoRepository.save(medicamento);
            return ResponseEntity.ok(updatedMedicamento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicamento(@PathVariable Long id) {
        Optional<Medicamento> optionalMedicamento = medicamentoRepository.findById(id);

        if (optionalMedicamento.isPresent()) {
            medicamentoRepository.delete(optionalMedicamento.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
