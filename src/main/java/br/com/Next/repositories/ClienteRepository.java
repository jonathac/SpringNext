package br.com.Next.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.Next.bean.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	Cliente findByIdCliente(Integer idCliente);
	
}
