package br.edu.utfpr.pb.range.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.pb.range.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
