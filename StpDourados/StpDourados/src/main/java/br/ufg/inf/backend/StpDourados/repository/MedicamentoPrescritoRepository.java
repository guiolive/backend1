package br.ufg.inf.backend.StpDourados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufg.inf.backend.StpDourados.model.MedicamentoPrescrito;

@Repository
public interface MedicamentoPrescritoRepository extends JpaRepository<MedicamentoPrescrito, Long> {
}
