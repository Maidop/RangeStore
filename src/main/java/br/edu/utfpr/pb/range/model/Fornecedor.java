package br.edu.utfpr.pb.range.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "fornecedor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString
public class Fornecedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 254, nullable = false)
	private String empresa;
	
	@Column(length = 254, nullable = false)
	private String razaoSocial;
	
	@Column(length = 15, nullable = false)
	private String cnpj;
	
	@Column(length = 254, nullable = false)
	private String responsavel;
	
	@Column(length = 12, nullable = false)
	private String telefone;
}
