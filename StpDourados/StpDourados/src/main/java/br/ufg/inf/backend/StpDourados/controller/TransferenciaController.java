package br.ufg.inf.backend.StpDourados.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufg.inf.backend.StpDourados.model.Transferencia;
import br.ufg.inf.backend.StpDourados.service.TransferenciaService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

	private final TransferenciaService service;

	@GetMapping
	public java.util.List<Transferencia> listar() {
		return service.listar();
	}

	@GetMapping("/{id}")
	public Transferencia obter(@PathVariable Long id) {
		return service.obter(id);
	}

	@PostMapping
	public Transferencia adicionar(@RequestBody Transferencia transferencia) {
		return service.salvar(transferencia);
	}

	@PutMapping("/{id}")
	public Transferencia atualizar(@PathVariable Long id, @RequestBody Transferencia transferencia) {
		return service.salvar(id, transferencia);
	}

	@DeleteMapping("/{id}")
	public void remover(@PathVariable Long id) {
		service.remover(id);
	}
}
