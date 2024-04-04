package br.com.vainaweb.escolat3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vainaweb.escolat3.dto.DadosColaborador;
import br.com.vainaweb.escolat3.model.ColaboradorModel;
import br.com.vainaweb.escolat3.repository.ColaboradorRepository;
import br.com.vainaweb.escolat3.service.ColaboradorService;

@RestController
@RequestMapping("/colaborador-teste")
public class ColaboradorController {
	
	@Autowired //retorna o controle para o spring container
	private ColaboradorService service;
	private ColaboradorRepository repository;
	
	@GetMapping
	public List<ColaboradorModel> encontrarColaboradores() {
		return service.encontrarColaboradores();
	}
	
	@GetMapping("/{id}")
	public Optional<ColaboradorModel> encontrarUmColaboradorPorId(@PathVariable Long id) {
		var c = service.encontrarUmColaborador(id);
		return c; // refatoração na segunda 24/03
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ColaboradorModel> listarPorId(@PathVariable Long id) {
		return repository.findById(id)
				.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@PostMapping
	public String cadastrarColaborador(@RequestBody DadosColaborador dados) {
		service.cadastrarColaborador(dados);
		return "deu bom";
	}
	

}
