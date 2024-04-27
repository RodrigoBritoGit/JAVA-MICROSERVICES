package br.com.mscartoes.repository.ClienteCartaoRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mscartoes.model.clienteCartaoModel.ClienteCartao;

public interface ClienteCartaoRepository extends JpaRepository<ClienteCartao, Long> {
	
	List<ClienteCartao> findByCpf(String cpf);

}
