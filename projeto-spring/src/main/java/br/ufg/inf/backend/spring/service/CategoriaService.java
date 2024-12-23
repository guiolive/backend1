package br.ufg.inf.backend.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.backend.spring.model.Categoria;
import br.ufg.inf.backend.spring.repository.CategoriaRepository;



@Service
public class CategoriaService {

	@Autowired
	   private CategoriaRepository categoriaRepository;

	   public List<Categoria> listarCategoria() {
	       return categoriaRepository.findAll();
	   }

	   public Categoria salvarCategoria(Categoria categoria) {
	       return categoriaRepository.save(categoria);
	   }

	   public Categoria obterCategoriaPorId(Long id) {
	       return categoriaRepository.findById(id).orElse(null);
	   }
	   public void deletarCategoriaPorId(Long id) {
		  categoriaRepository.deleteById(id);
	   }
}
