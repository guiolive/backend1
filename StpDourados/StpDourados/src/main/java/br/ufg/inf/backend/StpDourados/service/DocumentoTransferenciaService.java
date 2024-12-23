package br.ufg.inf.backend.StpDourados.service;

import org.springframework.stereotype.Service;

import br.ufg.inf.backend.StpDourados.model.DocumentoTransferencia;
import br.ufg.inf.backend.StpDourados.repository.DocumentoTransferenciaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DocumentoTransferenciaService {

    private final DocumentoTransferenciaRepository repository;

    public java.util.List<DocumentoTransferencia> listar() {
        return repository.findAll();
    }

    public DocumentoTransferencia obter(Long id) {
        return repository.findById(id).orElse(null);
    }

    public DocumentoTransferencia salvar(DocumentoTransferencia documentoTransferencia) {
        return repository.save(documentoTransferencia);
    }

    public DocumentoTransferencia salvar(Long id, DocumentoTransferencia documentoTransferencia) {
        documentoTransferencia.setId(id);
        return repository.save(documentoTransferencia);
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }
}