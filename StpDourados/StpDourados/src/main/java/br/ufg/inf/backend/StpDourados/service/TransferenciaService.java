package br.ufg.inf.backend.StpDourados.service;

import org.springframework.stereotype.Service;

import br.ufg.inf.backend.StpDourados.model.Transferencia;
import br.ufg.inf.backend.StpDourados.repository.TransferenciaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TransferenciaService {

    private final TransferenciaRepository repository;

    public java.util.List<Transferencia> listar() {
        return repository.findAll();
    }

    public Transferencia obter(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Transferencia salvar(Transferencia transferencia) {
        return repository.save(transferencia);
    }

    public Transferencia salvar(Long id, Transferencia transferencia) {
        transferencia.setId(id);
        return repository.save(transferencia);
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }
}