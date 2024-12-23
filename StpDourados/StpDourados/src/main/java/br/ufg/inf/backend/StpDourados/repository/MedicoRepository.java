package br.ufg.inf.backend.StpDourados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufg.inf.backend.StpDourados.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, String> {

}