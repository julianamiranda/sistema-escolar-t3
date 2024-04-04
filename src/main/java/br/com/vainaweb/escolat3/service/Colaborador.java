package br.com.vainaweb.escolat3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.vainaweb.escolat3.dto.DadosColaborador;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Service
public class Colaborador {
	
	private List<Colaborador> lista = new ArrayList<Colaborador>();
	
	private Long id;
	private String nome;
	private String cpf;
	private String endereco;
	
	public Colaborador(Long id, String nome, String cpf, String endereco) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
	}
	
	// ---- inicio da service ---- 
	
	public void cadastrar(DadosColaborador dados) {
		lista.add(new Colaborador(dados.id(), dados.nome(),dados.cpf(), dados.endereco()));
	}
	
	public List<Colaborador> encontrarColaboradores(){
		return lista;
	}
	
	public Colaborador encontrarUmColaborador(Long id) {
		for(var colaborador : lista) {
			if(colaborador.getId() == id) {
				return colaborador;
			}
		}
		return null;
	}
	

}
