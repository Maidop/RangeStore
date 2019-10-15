package br.edu.utfpr.pb.range.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.pb.range.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByUsername(String username);
}
