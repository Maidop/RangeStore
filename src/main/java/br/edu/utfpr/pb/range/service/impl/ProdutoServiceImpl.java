package br.edu.utfpr.pb.range.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.edu.utfpr.pb.range.model.Produto;
import br.edu.utfpr.pb.range.repository.ProdutoRepository;
import br.edu.utfpr.pb.range.service.ProdutoService;

@Service
public class ProdutoServiceImpl extends CrudServiceImpl<Produto, Long> 
	implements ProdutoService{
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	protected JpaRepository<Produto, Long> getRepository() {
		return produtoRepository;
	}

}
