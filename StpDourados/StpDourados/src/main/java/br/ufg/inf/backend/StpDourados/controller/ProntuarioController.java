package br.ufg.inf.backend.StpDourados.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufg.inf.backend.StpDourados.model.Prontuario;
import br.ufg.inf.backend.StpDourados.service.ProntuarioService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/prontuarios")
public class ProntuarioController {

    private final ProntuarioService service;

    @GetMapping
    public java.util.List<Prontuario> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Prontuario obter(@PathVariable Long id) {
        return service.obter(id);
    }

    @PostMapping
    public Prontuario adicionar(@RequestBody Prontuario prontuario) {
        return service.salvar(prontuario);
    }

    @PutMapping("/{id}")
    public Prontuario atualizar(@PathVariable Long id, @RequestBody Prontuario prontuario) {
        return service.salvar(id, prontuario);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        service.remover(id);
    }
}
