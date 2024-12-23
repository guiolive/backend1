package br.ufg.inf.backend.spring.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufg.inf.backend.spring.model.Categoria;
import br.ufg.inf.backend.spring.model.Produto;
import br.ufg.inf.backend.spring.service.CategoriaService;
import br.ufg.inf.backend.spring.service.ProdutoService;

@Controller
public class ProdutoController {

   @Autowired
   private ProdutoService produtoService;
   
   @Autowired
   private CategoriaService categoriaService;

   @GetMapping("/produtos")
   public String listarProdutos(Model model, @RequestParam(required = false) String sucesso) {
       model.addAttribute("produtos", produtoService.listarProdutos());
       model.addAttribute("sucesso", sucesso);
       return "produtos";
   }
   
   @GetMapping("/produtos/adicionar")
   public String mostrarFormularioAdicionarProduto(Model model) {
	  return "adicionar-produto";
   }
   
   @PostMapping("/produtos")
   public String adicionarProduto(@RequestParam String nome, @RequestParam double preco, RedirectAttributes redirectAttributes) {
       Produto produto = new Produto();
       produto.setNome(nome);
       produto.setPreco(preco);
       produtoService.salvarProduto(produto);
       redirectAttributes.addAttribute("sucesso", "Produto adicionado com sucesso!");
       return "redirect:/produtos";
   }
   @GetMapping("/produtos/editar")
   public String mostrarFormularioEditarProduto(@RequestParam("id") Long id, Model model) {
       Produto produto = produtoService.obterProdutoPorId(id);
       List<Categoria> categorias = categoriaService.listarCategoria();
       model.addAttribute("produto", produto);
       model.addAttribute("categorias", categorias);
       return "editar-produto";
   }
   @PostMapping("/produtos/editar")
   public String editarProduto(@RequestParam("id") Long id, @RequestParam("nome") String nome,
                               @RequestParam("preco") double preco, RedirectAttributes redirectAttributes) {
       Produto produto = produtoService.obterProdutoPorId(id);
       produto.setNome(nome);
       produto.setPreco(preco);
       produtoService.salvarProduto(produto);
       redirectAttributes.addAttribute("sucesso", "Produto atualizado com sucesso!");
       return "redirect:/produtos";
   }
   @PostMapping("/produtos/deletar")
   public String deletarProduto(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
       produtoService.deletarProdutoPorId(id);
       redirectAttributes.addAttribute("sucesso", "Produto deletado com sucesso!");
       return "redirect:/produtos";
   }
}
