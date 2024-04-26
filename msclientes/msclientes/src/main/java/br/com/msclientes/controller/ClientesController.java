package br.com.msclientes.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.msclientes.model.Cliente;
import br.com.msclientes.service.ClienteService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClientesController {
	@Autowired
	private ClienteService service;

	@GetMapping
	public String status() {
		return "ok";
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Cliente cliente) {
		Cliente savedCliente = service.save(cliente); // Salva o cliente e recebe o cliente recém-salvo
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedCliente.getId()) // Usa o ID do cliente recém-salvo para construir o URI
				.toUri();
		return ResponseEntity.created(location).body(savedCliente); // Retorna o URI do novo cliente e o próprio cliente
																	// como corpo da resposta
	}

	@GetMapping(params = "cpf")
	public ResponseEntity<Cliente> dadosCliente(@RequestParam("cpf") String cpf) {
		Cliente cliente = service.getByCpf(cpf);
		if ((cliente == null)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(cliente);
	}

}
