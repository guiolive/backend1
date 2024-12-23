package br.ufg.inf.backend.StpDourados.service;

import org.springframework.stereotype.Service;

import br.ufg.inf.backend.StpDourados.model.Prontuario;
import br.ufg.inf.backend.StpDourados.repository.ProntuarioRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProntuarioService {

    private final ProntuarioRepository repository;

    public java.util.List<Prontuario> listar() {
        return repository.findAll();
    }

    public Prontuario obter(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Prontuario salvar(Prontuario prontuario) {
        return repository.save(prontuario);
    }

    public Prontuario salvar(Long id, Prontuario prontuario) {
        prontuario.setId(id);
        return repository.save(prontuario);
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }
}