package br.edu.utfpr.pb.range.service;

import java.util.List;

import br.edu.utfpr.pb.range.model.Categoria;

public interface CategoriaService extends CrudService<Categoria, Long> {
	List<Categoria> findByNomeLike(String categoria);
}
