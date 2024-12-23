package br.ufg.inf.backend.StpDourados.service;

import org.springframework.stereotype.Service;

import br.ufg.inf.backend.StpDourados.model.Solicitacao;
import br.ufg.inf.backend.StpDourados.repository.SolicitacaoRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SolicitacaoService {

    private final SolicitacaoRepository repository;

    public java.util.List<Solicitacao> listar() {
        return repository.findAll();
    }

    public Solicitacao obter(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Solicitacao salvar(Solicitacao paciente) {
        return repository.save(paciente);
    }

    public Solicitacao salvar(Long id, Solicitacao paciente) {
        paciente.setId(id);
        return repository.save(paciente);
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }
}