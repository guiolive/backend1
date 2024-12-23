package br.ufg.inf.backend.StpDourados.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.backend.StpDourados.model.Especialidade;
import br.ufg.inf.backend.StpDourados.repository.EspecialidadeRepository;

@Service
public class EspecialidadeService {

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    public List<Especialidade> findAll() {
        return especialidadeRepository.findAll();
    }

    public Optional<Especialidade> findById(Long id) {
        return especialidadeRepository.findById(id);
    }

    public Especialidade save(Especialidade especialidade) {
        return especialidadeRepository.save(especialidade);
    }

    public void deleteById(Long id) {
        especialidadeRepository.deleteById(id);
    }
}