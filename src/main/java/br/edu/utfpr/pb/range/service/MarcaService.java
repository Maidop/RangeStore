package br.edu.utfpr.pb.range.service;

import java.util.List;

import br.edu.utfpr.pb.range.model.Marca;

public interface MarcaService extends CrudService<Marca, Long> {
	List<Marca> findByNomeLike(String nome);
}
