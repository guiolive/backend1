package br.ufg.inf.backend.StpDourados.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufg.inf.backend.StpDourados.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, String> {

}