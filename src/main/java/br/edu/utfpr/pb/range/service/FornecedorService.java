package br.edu.utfpr.pb.range.service;

import java.util.List;

import br.edu.utfpr.pb.range.model.Fornecedor;

public interface FornecedorService extends CrudService<Fornecedor, Long> {
	List<Fornecedor> findByEmpresaLike(String empresa);
}
