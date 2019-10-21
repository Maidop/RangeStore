package br.edu.utfpr.pb.range.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CompraProdutoPK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@ManyToOne
	@JoinColumn(name = "compra_id", referencedColumnName = "id")
	private Compra compra;
	
	
	@ManyToOne
	@JoinColumn(name = "produto_id", referencedColumnName = "id")
	private Produto produto;
	
}
