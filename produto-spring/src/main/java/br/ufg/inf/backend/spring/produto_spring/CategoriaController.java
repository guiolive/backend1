package br.ufg.inf.backend.spring.produto_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public String listarCategorias(Model model) {
        List<Categoria> categorias = categoriaRepository.findAll();
        model.addAttribute("categorias", categorias);
        return "categorias";
    }

    @GetMapping("/nova")
    public String mostrarFormularioDeCadastro(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "formularioCategoria";
    }

    @PostMapping
    public String adicionarCategoria(@ModelAttribute Categoria categoria) {
        categoriaRepository.save(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEdicao(@PathVariable Long id, Model model) {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID de categoria inválido: " + id));
        model.addAttribute("categoria", categoria);
        return "formularioCategoria";
    }

    @PostMapping("/editar/{id}")
    public String atualizarCategoria(@PathVariable Long id, @ModelAttribute Categoria categoria) {
        categoria.setId(id);
        categoriaRepository.save(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/deletar/{id}")
    public String deletarCategoria(@PathVariable Long id) {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID de categoria inválido: " + id));
        categoriaRepository.delete(categoria);
        return "redirect:/categorias";
    }
}

