package br.ufg.inf.backend.StpDourados.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.backend.StpDourados.model.MedicamentoPrescrito;
import br.ufg.inf.backend.StpDourados.repository.MedicamentoPrescritoRepository;

@Service
public class MedicamentoPrescritoService {

    @Autowired
    private MedicamentoPrescritoRepository medicamentoPrescritoRepository;

    public List<MedicamentoPrescrito> findAll() {
        return medicamentoPrescritoRepository.findAll();
    }

    public Optional<MedicamentoPrescrito> findById(Long id) {
        return medicamentoPrescritoRepository.findById(id);
    }

    public MedicamentoPrescrito save(MedicamentoPrescrito medicamentoPrescrito) {
        return medicamentoPrescritoRepository.save(medicamentoPrescrito);
    }

    public void deleteById(Long id) {
        medicamentoPrescritoRepository.deleteById(id);
    }
}