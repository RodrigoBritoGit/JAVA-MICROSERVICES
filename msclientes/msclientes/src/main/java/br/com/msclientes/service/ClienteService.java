package br.com.msclientes.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.msclientes.model.Cliente;
import br.com.msclientes.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {
	@Autowired
	private final ClienteRepository repository;

	// Construtor explicitamente definido
	@Autowired
	public ClienteService(ClienteRepository repository) {
		this.repository = repository;
	}

	@Transactional
	public Cliente save(Cliente cliente) {
		return repository.save(cliente);
	}

	public Cliente getByCpf(String cpf) {
		return repository.findByCpf(cpf);
	}

}
