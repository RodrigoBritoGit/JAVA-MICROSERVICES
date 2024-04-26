package br.com.msclientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.msclientes.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {

}
