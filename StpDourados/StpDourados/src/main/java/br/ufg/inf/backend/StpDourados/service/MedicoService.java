package br.ufg.inf.backend.StpDourados.service;

import org.springframework.stereotype.Service;

import br.ufg.inf.backend.StpDourados.model.Medico;
import br.ufg.inf.backend.StpDourados.repository.MedicoRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MedicoService {

    private final MedicoRepository repository;

    public java.util.List<Medico> listar() {
        return repository.findAll();
    }

    public Medico obter(String crm) {
        return repository.findById(crm).orElse(null);
    }

    public Medico salvar(Medico paciente) {
        return repository.save(paciente);
    }

    public Medico salvar(String crm, Medico paciente) {
        paciente.setCrm(crm);
        return repository.save(paciente);
    }

    public void remover(String crm) {
        repository.deleteById(crm);
    }
}