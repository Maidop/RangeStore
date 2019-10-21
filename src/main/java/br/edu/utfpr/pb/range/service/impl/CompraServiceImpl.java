package br.edu.utfpr.pb.range.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.pb.range.model.Compra;
import br.edu.utfpr.pb.range.repository.CompraRepository;

public class CompraServiceImpl extends CrudServiceImpl<Compra, Long> {

	@Autowired
	private CompraRepository compraRepository;
	
	@Override
	protected JpaRepository<Compra, Long> getRepository() {
		return compraRepository;
	}

}
