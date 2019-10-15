package br.edu.utfpr.pb.range.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.utfpr.pb.range.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

	List<Fornecedor> findByEmpresaLike(String empresa);
}
