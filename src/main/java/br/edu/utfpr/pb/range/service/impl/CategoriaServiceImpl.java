package br.edu.utfpr.pb.range.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.edu.utfpr.pb.range.model.Categoria;
import br.edu.utfpr.pb.range.repository.CategoriaRepository;
import br.edu.utfpr.pb.range.service.CategoriaService;

@Service
public class CategoriaServiceImpl extends CrudServiceImpl<Categoria, Long>
	implements CategoriaService{
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public List<Categoria> findByNomeLike(String categoria) {
		return categoriaRepository.findByNomeLike(categoria);
	}

	@Override
	protected JpaRepository<Categoria, Long> getRepository() {
		return categoriaRepository;
	}

}
