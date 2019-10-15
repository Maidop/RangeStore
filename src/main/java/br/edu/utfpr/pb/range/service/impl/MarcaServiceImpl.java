package br.edu.utfpr.pb.range.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.edu.utfpr.pb.range.model.Marca;
import br.edu.utfpr.pb.range.repository.MarcaRepository;
import br.edu.utfpr.pb.range.service.MarcaService;

@Service
public class MarcaServiceImpl extends CrudServiceImpl<Marca, Long> 
	implements MarcaService{

	@Autowired
	private MarcaRepository marcaRepository;
	
	@Override
	public List<Marca> findByNomeLike(String nome) {
		return marcaRepository.findByNomeLike(nome);
	}

	@Override
	protected JpaRepository<Marca, Long> getRepository() {
		return marcaRepository;
	}

}
