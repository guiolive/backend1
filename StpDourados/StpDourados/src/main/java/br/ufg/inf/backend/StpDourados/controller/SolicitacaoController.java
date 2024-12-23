package br.ufg.inf.backend.StpDourados.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufg.inf.backend.StpDourados.model.Solicitacao;
import br.ufg.inf.backend.StpDourados.service.SolicitacaoService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/solicitacoes")
public class SolicitacaoController {

	private final SolicitacaoService service;

	@GetMapping
	public java.util.List<Solicitacao> listar() {
		return service.listar();
	}

	@GetMapping("/{id}")
	public Solicitacao obter(@PathVariable Long id) {
		return service.obter(id);
	}

	@PostMapping
	public Solicitacao adicionar(@RequestBody Solicitacao solicitacao) {
		return service.salvar(solicitacao);
	}

	@PutMapping("/{id}")
	public Solicitacao atualizar(@PathVariable Long id, @RequestBody Solicitacao solicitacao) {
		return service.salvar(id, solicitacao);
	}

	@DeleteMapping("/{id}")
	public void remover(@PathVariable Long id) {
		service.remover(id);
	}
}
