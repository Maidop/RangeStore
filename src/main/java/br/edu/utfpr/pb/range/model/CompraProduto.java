package br.edu.utfpr.pb.range.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class CompraProduto {

	@EmbeddedId
	private CompraProdutoPK id;
	
	@Column(nullable = false)
	private Integer quantidade;
	
	@Column(nullable = false)
	private Double valor;
	
}
