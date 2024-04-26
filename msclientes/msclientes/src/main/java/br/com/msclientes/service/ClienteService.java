package br.com.msclientes.service;

import org.springframework.stereotype.Service;

import br.com.msclientes.model.Cliente;
import br.com.msclientes.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {
	
	private ClienteRepository repository;
	
	public Cliente save(Cliente cliente) {
		return repository.save(cliente);
	}

}
