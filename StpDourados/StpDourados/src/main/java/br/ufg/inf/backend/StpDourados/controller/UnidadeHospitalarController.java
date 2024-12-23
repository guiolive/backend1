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

import br.ufg.inf.backend.StpDourados.model.UnidadeHospitalar;
import br.ufg.inf.backend.StpDourados.service.UnidadeHospitalarService;

@RestController
@RequestMapping("/unidadesHospitalares")
public class UnidadeHospitalarController {

	@Autowired
	private UnidadeHospitalarService service;

	@GetMapping
	public ResponseEntity<List<UnidadeHospitalar>> findAll() {
		List<UnidadeHospitalar> unidadesHospitalares = service.findAll();
		return ResponseEntity.ok(unidadesHospitalares);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UnidadeHospitalar> findById(@PathVariable Long id) {
		Optional<UnidadeHospitalar> unidadeHospitalar = service.findById(id);
		return unidadeHospitalar.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@PostMapping
	public ResponseEntity<UnidadeHospitalar> create(@RequestBody UnidadeHospitalar unidadeHospitalar) {
		UnidadeHospitalar savedUnidadeHospitalar = service.save(unidadeHospitalar);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedUnidadeHospitalar);
	}

	@PutMapping("/{id}")
	public ResponseEntity<UnidadeHospitalar> update(@PathVariable Long id, @RequestBody UnidadeHospitalar unidadeHospitalar) {
		if (!service.findById(id).isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		unidadeHospitalar.setId(id);
		UnidadeHospitalar updatedUnidadeHospitalar = service.save(unidadeHospitalar);
		return ResponseEntity.ok(updatedUnidadeHospitalar);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		if (!service.findById(id).isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}