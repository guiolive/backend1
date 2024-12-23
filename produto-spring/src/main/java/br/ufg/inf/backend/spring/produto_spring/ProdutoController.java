package br.ufg.inf.backend.spring.produto_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public String listarProdutos(Model model) {
        List<Produto> produtos = produtoRepository.findAll();
        model.addAttribute("produtos", produtos);
        return "produtos";
    }

    @GetMapping("/novo")
    public String mostrarFormularioDeCadastro(Model model) {
        model.addAttribute("produto", new Produto());
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "formularioProduto";
    }

    @PostMapping
    public String adicionarProduto(@ModelAttribute Produto produto) {
    	produtoRepository.save(produto);
        return "redirect:/produtos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEdicao(@PathVariable Long id, Model model) {
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID de produto inválido: " + id));
        model.addAttribute("produto", produto);
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "formularioProduto";
    }

    @PostMapping("/editar/{id}")
    public String atualizarProduto(@PathVariable Long id, @ModelAttribute Produto produto) {
        produto.setId(id);
        produtoRepository.save(produto);
        return "redirect:/produtos";
    }

    @GetMapping("/deletar/{id}")
    public String deletarProduto(@PathVariable Long id) {
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID de produto inválido: " + id));
        produtoRepository.delete(produto);
        return "redirect:/produtos";
    }
}
