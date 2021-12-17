package com.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.domain.Livro;
import com.bookstore.dtos.LivroDTO;
import com.bookstore.exceptions.ObjectNotFoundException;
import com.bookstore.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	public List<Livro> findAll(Integer id_cat) {
		 categoriaService.findById(id_cat);
		 return repository.findAllByCategoria(id_cat);
	}
	
	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow((() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", tipo: " + Livro.class.getName())));

	}
	
	public Livro update(Integer id, LivroDTO livroDTO) {
		Livro obj = findById(id);
		obj.setTitulo(livroDTO.getTitulo());
		return repository.save(obj);
	}
	
	public Livro create(Livro livro) {
		return repository.save(livro);
	}
	
	public void delete(Integer id) {
		 repository.deleteById(id);
	}
}