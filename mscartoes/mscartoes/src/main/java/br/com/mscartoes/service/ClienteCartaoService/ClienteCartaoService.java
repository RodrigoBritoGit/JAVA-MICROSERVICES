package br.com.mscartoes.service.ClienteCartaoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mscartoes.model.clienteCartaoModel.ClienteCartao;
import br.com.mscartoes.repository.ClienteCartaoRepository.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;

@Service
public class ClienteCartaoService {
	
	@Autowired
	private ClienteCartaoRepository repository;

	public ClienteCartaoService(ClienteCartaoRepository repository) {
		super();
		this.repository = repository;
	}
	
	public List<ClienteCartao> listCartoesByCpf(String cpf){
		return repository.findByCpf(cpf);
	}

}
