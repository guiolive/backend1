package br.ufg.inf.backend.StpDourados.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.backend.StpDourados.model.Medicamento;
import br.ufg.inf.backend.StpDourados.repository.MedicamentoRepository;

@Service
public class MedicamentoService {

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    public List<Medicamento> findAll() {
        return medicamentoRepository.findAll();
    }

    public Optional<Medicamento> findById(Long id) {
        return medicamentoRepository.findById(id);
    }

    public Medicamento save(Medicamento medicamento) {
        return medicamentoRepository.save(medicamento);
    }

    public void deleteById(Long id) {
        medicamentoRepository.deleteById(id);
    }
}