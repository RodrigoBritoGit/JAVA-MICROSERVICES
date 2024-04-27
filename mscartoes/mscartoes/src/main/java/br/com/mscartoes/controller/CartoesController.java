package br.com.mscartoes.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.HttpStatus;

import br.com.mscartoes.model.Cartao;
import br.com.mscartoes.service.CartaoService;

@RestController
@RequestMapping("/cartoes")
public class CartoesController {

	private CartaoService service;

	public CartoesController(CartaoService service) {
		this.service = service;
	}

	@GetMapping
	public String status() {
		return "ok";
	}

	@PostMapping
	public ResponseEntity<Void> cadastrar(@RequestBody Cartao request) {
		service.save(request);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping("/listar")
	public Iterable<Cartao> listar(@RequestParam("renda") Long renda) {
		List<Cartao> list = service.getCartoesRendaMenorIgual(renda);
		return service.getCartoesRendaMenorIgual(renda);
	}
}
