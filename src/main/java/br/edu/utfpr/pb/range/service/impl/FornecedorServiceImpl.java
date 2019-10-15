package br.edu.utfpr.pb.range.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.edu.utfpr.pb.range.model.Fornecedor;
import br.edu.utfpr.pb.range.repository.FornecedorRepository;
import br.edu.utfpr.pb.range.service.FornecedorService;

@Service
public class FornecedorServiceImpl extends CrudServiceImpl<Fornecedor, Long> implements FornecedorService {

	@Autowired
	private FornecedorRepository fornecedorRepository;

	@Override
	public List<Fornecedor> findByEmpresaLike(String empresa) {
		return fornecedorRepository.findByEmpresaLike(empresa);
	}

	@Override
	protected JpaRepository<Fornecedor, Long> getRepository() {
		return fornecedorRepository;
	}
	
	
}
