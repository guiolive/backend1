package br.ufg.inf.backend.StpDourados.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufg.inf.backend.StpDourados.model.Prontuario;

public interface ProntuarioRepository extends JpaRepository<Prontuario, Long> {

}
