package br.ufg.inf.backend.produto.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.backend.produto.model.Produto;
import br.ufg.inf.backend.produto.repository.ProdutoRepository;

//Request -> Controller -> Service -> Repository -> Spring Data -> Hibernate -> H2BD
//Aqui onde fica a validacao de dados 
@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	// Ler Produto
	public List<Produto> listarProdutos() {
		return produtoRepository.findAll();
	}

	// Salva Produto
	public Produto salvarProduto(Produto produto) {
		return produtoRepository.save(produto);
	}

	// Deletar Produto
	public void deletarProduto(Long produtoID) {
		produtoRepository.deleteById(produtoID);
	}

	// Atualizar Produto
	public Produto atualizarProduto(Produto produto, Long produtoID) {

		Produto produtoBD = produtoRepository.findById(produtoID).get();
		// verificar se tem nome
		if (Objects.nonNull(produto.getNomeProduto()) && !"".equalsIgnoreCase(produto.getNomeProduto())) {
			produtoBD.setNomeProduto(produto.getNomeProduto());
		}
		if (Objects.nonNull(produto.getPrecoProduto())) {
			produtoBD.setPrecoProduto(produto.getPrecoProduto());
		}

		return produtoRepository.save(produto);
	}

	// Selecionar Produto
	public Produto selecionarProduto(Long produtoID) {
		return produtoRepository.findById(produtoID).orElse(null);
	}
}
