package br.ufg.inf.backend.StpDourados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufg.inf.backend.StpDourados.model.Solicitacao;

@Repository
public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {
}