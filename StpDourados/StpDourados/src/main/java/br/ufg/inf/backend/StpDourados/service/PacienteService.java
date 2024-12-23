package br.ufg.inf.backend.StpDourados.service;

import org.springframework.stereotype.Service;

import br.ufg.inf.backend.StpDourados.model.Paciente;
import br.ufg.inf.backend.StpDourados.repository.PacienteRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PacienteService {

    private final PacienteRepository repository;

    public java.util.List<Paciente> listar() {
        return repository.findAll();
    }

    public Paciente obter(String cpf) {
        return repository.findById(cpf).orElse(null);
    }

    public Paciente salvar(Paciente paciente) {
        return repository.save(paciente);
    }

    public Paciente salvar(String cpf, Paciente paciente) {
        paciente.setCpf(cpf);
        return repository.save(paciente);
    }

    public void remover(String cpf) {
        repository.deleteById(cpf);
    }
}