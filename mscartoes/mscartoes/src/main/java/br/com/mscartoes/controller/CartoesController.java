package br.com.mscartoes.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import br.com.mscartoes.model.CartaoModel.Cartao;
import br.com.mscartoes.model.clienteCartaoModel.CartoesPorClienteResponse;
import br.com.mscartoes.model.clienteCartaoModel.ClienteCartao;
import br.com.mscartoes.service.CartaoService;
import br.com.mscartoes.service.ClienteCartaoService.ClienteCartaoService;

@RestController
@RequestMapping("/cartoes")
public class CartoesController {
	
	@Autowired
	private CartaoService service;
	
	@Autowired
	private ClienteCartaoService clienteCartaoservice;

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

	@GetMapping("/listarPorcpf")
	public ResponseEntity<List<CartoesPorClienteResponse>> listarCartaoPorCpf(@RequestParam("cpf") String cpf) {
		List<ClienteCartao> lista = clienteCartaoservice.listCartoesByCpf(cpf);
		List<CartoesPorClienteResponse> resultado = lista.stream().map(CartoesPorClienteResponse::fromModdel)
				.collect(Collectors.toList());

		return ResponseEntity.ok(resultado);
	}

}
