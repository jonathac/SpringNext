package br.com.Next.bo;

import org.springframework.stereotype.Service;

import br.com.Next.bean.Cliente;
import br.com.Next.repositories.ClienteRepository;

@Service
public class ClienteBo {

	private ClienteRepository clienteRepository;

	public ClienteBo(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public boolean inserirCliente(Cliente cliente) {
		
		//validacao
		
		try {
			this.clienteRepository.save(cliente);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
}
