package br.ufg.inf.backend.StpDourados.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufg.inf.backend.StpDourados.model.Endereco;
import br.ufg.inf.backend.StpDourados.service.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;

	@GetMapping
	public ResponseEntity<List<Endereco>> findAll() {
		List<Endereco> enderecos = enderecoService.findAll();
		return ResponseEntity.ok(enderecos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Endereco> findById(@PathVariable Long id) {
		Optional<Endereco> endereco = enderecoService.findById(id);
		return endereco.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@PostMapping
	public ResponseEntity<Endereco> create(@RequestBody Endereco endereco) {
		Endereco savedEndereco = enderecoService.save(endereco);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedEndereco);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Endereco> update(@PathVariable Long id, @RequestBody Endereco endereco) {
		if (!enderecoService.findById(id).isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		endereco.setId(id);
		Endereco updatedEndereco = enderecoService.save(endereco);
		return ResponseEntity.ok(updatedEndereco);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		if (!enderecoService.findById(id).isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		enderecoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}