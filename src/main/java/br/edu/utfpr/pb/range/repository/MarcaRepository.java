package br.edu.utfpr.pb.range.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.pb.range.model.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
	List<Marca> findByNomeLike(String nome);
}
