package br.ufg.inf.backend.produto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufg.inf.backend.produto.model.Produto;
import br.ufg.inf.backend.produto.service.ProdutoService;

//Request -> Controller -> Service -> Repository -> Spring Data -> Hibernate -> H2BD
//Aqui somente controlle de endPoints
//Anotacao
@Controller
@RequestMapping("/api/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public List<Produto> listarProdutos() {
		return produtoService.listarProdutos();
	}

	@PostMapping
	public Produto adicionarProduto(@RequestBody Produto produto) {
		return produtoService.salvarProduto(produto);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> obterProduto(@PathVariable Long id) {
		Produto produto = produtoService.selecionarProduto(id);
		if (produto != null) {
			return ResponseEntity.ok(produto);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Produto> editarProduto(@PathVariable Long id, @RequestBody Produto produtoDetalhes) {
		Produto produto = produtoService.selecionarProduto(id);
		if (produto != null) {
			produto.setNomeProduto(produtoDetalhes.getNomeProduto());
			produto.setPrecoProduto(produtoDetalhes.getPrecoProduto());
			return ResponseEntity.ok(produtoService.salvarProduto(produto));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
		produtoService.deletarProduto(id);
		return ResponseEntity.noContent().build();
	}
}
