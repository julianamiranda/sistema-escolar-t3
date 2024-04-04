package br.com.vainaweb.escolat3.model;

import br.com.vainaweb.escolat3.enums.Cargo;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ColaboradorModel {
	
	@Id
	private Long id;
	
	private String nome;
	private String email;
	private String cpf;
	private Cargo cargo;
	
	@Embedded
	private Endereco endereco;

}
