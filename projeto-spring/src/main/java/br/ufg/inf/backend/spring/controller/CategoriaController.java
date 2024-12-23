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
import br.ufg.inf.backend.spring.service.CategoriaService;

@Controller
public class CategoriaController {
	@Autowired
	private CategoriaService categoriaService;

	@GetMapping("/form")
    public String mostrarFormulario(Model model) {
        List<Categoria> categorias = Arrays.asList(
                new Categoria((long) 1, "Tecnologia"),
                new Categoria((long) 2, "Ciência"),
                new Categoria((long) 3, "Arte")
        );
        model.addAttribute("categorias", categorias);
        return "formulario";
    }
	@GetMapping("/categoria")
	public String listarCategorias(Model model, @RequestParam(required = false) String sucesso) {
		model.addAttribute("categorias", categoriaService.listarCategoria());
		model.addAttribute("sucesso", sucesso);
		return "categoria";
	}
	
	@GetMapping("/categoria/adicionar")
	public String mostrarFormularioAdicionarCategoria() {
		return "adicionar-categoria";
	}
	
	@PostMapping("/categoria")
	public String adicionarCategoria(@RequestParam String nome, RedirectAttributes redirectAttributes) {
		Categoria categoria = new Categoria();
		categoria.setNome(nome);
		categoriaService.salvarCategoria(categoria);
		redirectAttributes.addAttribute("sucesso", "Categoria salva com sucesso!");
		return "redirect:/categoria";
	}

	@GetMapping("/categoria/editar")
	public String mostrarFormularioEditarCategoria(@RequestParam("id") Long id, Model model) {
		Categoria categoria = categoriaService.obterCategoriaPorId(id);
		model.addAttribute("categoria", categoria);
		return "editar-categoria";
	}
	@PostMapping("/categoria/editar")
	public String editarCategoria(@RequestParam("id") Long id, @RequestParam("nome") String nome, RedirectAttributes redirectAttributes) {
		Categoria categoria = categoriaService.obterCategoriaPorId(id);
		categoria.setNome(nome);
		categoriaService.salvarCategoria(categoria);
		redirectAttributes.addAttribute("sucesso", "Categoria atualizado com sucesso!");
		return "redirect:/categoria";
	}
	@PostMapping("/categoria/deletar")
	public String deletarCategoria(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
		categoriaService.deletarCategoriaPorId(id);
		redirectAttributes.addAttribute("sucesso", "Categoria deletado com sucesso!");
		return "redirect:/categoria";
	}
}
