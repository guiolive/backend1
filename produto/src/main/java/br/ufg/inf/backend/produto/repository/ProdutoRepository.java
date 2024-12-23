package br.ufg.inf.backend.produto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufg.inf.backend.produto.model.Produto;

//Request -> Controller -> Service -> Repository -> Spring Data -> Hibernate -> H2BD
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
