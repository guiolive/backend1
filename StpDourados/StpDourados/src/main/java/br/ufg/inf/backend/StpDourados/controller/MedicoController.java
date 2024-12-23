package br.ufg.inf.backend.StpDourados.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufg.inf.backend.StpDourados.model.Medico;
import br.ufg.inf.backend.StpDourados.service.MedicoService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/medicos")
public class MedicoController {

	private final MedicoService service;

	@GetMapping
	public java.util.List<Medico> listar() {
		return service.listar();
	}

	@GetMapping("/{crm}")
	public Medico obter(@PathVariable String crm) {
		return service.obter(crm);
	}

	@PostMapping
	public Medico adicionar(@RequestBody Medico medico) {
		return service.salvar(medico);
	}

	@PutMapping("/{crm}")
	public Medico atualizar(@PathVariable String crm, @RequestBody Medico medico) {
		return service.salvar(crm, medico);
	}

	@DeleteMapping("/{crm}")
	public void remover(@PathVariable String crm) {
		service.remover(crm);
	}
}