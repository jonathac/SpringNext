package br.com.Next.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.Next.repositories.ClienteRepository;

@Controller
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@RequestMapping(name = "/", method = RequestMethod.GET)
	public String getIndex() {
		return "index";
	}
	
}
