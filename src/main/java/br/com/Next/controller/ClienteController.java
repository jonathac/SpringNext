package br.com.Next.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.Next.bean.Cliente;
import br.com.Next.bo.ClienteBo;
import br.com.Next.dto.ClienteDTO;
import br.com.Next.repositories.ClienteRepository;

@Controller
@RequestMapping("/")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	private ClienteDTO cliDTO;

	@GetMapping	
	public String getIndex(Model model) {
		ClienteDTO cliDTO = new ClienteDTO();
		model.addAttribute("clienteDTO", cliDTO);
		return "index";
	}
	
	@GetMapping("cadastro")
	public String getCadastro(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		
		return "cadastro";
	}
	
	@PostMapping("cadastrar")
	public String insertCliente(Cliente cliente) {
				
		ClienteBo cliBO = this.getClienteBO();
		cliBO.inserirCliente(cliente);
		
		return "redirect:/?inseriu=true";
	}
	
	
	public ClienteBo getClienteBO() {
		return new ClienteBo(this.clienteRepo);
	}
	
	@PostMapping("login")
	public String login(ClienteDTO clienteDTO, ModelMap model) {
		Cliente cli = clienteRepo.findByCpfAndSenha(clienteDTO.getCpf(), clienteDTO.getSenha());
		
		if(cli == null) {
			return "redirect:/?logininvalido";
		}
		
		clienteDTO.setNome(cli.getNome());
		cliDTO = clienteDTO;
		
		return "redirect:/home";
	}
	/*
	@GetMapping("extrato")
	public String getExtrato() {
		return "extrato";
	}*/
	
	@GetMapping("extrato")
	public String getExtrato(ModelMap model) {
		Cliente cliente = clienteRepo.findByNome(cliDTO.getNome());
		model.addAttribute("clientes", cliente.getNome());
		model.addAttribute("saldo", cliente.getSaldo());
		
		return "extrato";
	}
	
	@GetMapping("home")
	public String getHome(ModelMap model) {
		Cliente cliente = clienteRepo.findByNome(cliDTO.getNome());
		model.addAttribute("clientes", cliente.getNome());
		model.addAttribute("saldo", cliente.getSaldo());
		
		return "home";
	}
	
	@GetMapping("pix")
	public String getPix(ModelMap model) {
		Cliente cliente = clienteRepo.findByNome(cliDTO.getNome());
		model.addAttribute("clientes", cliente.getNome());
		model.addAttribute("saldo", cliente.getSaldo());
		
		return "pix";
	}
			
	public Cliente buscaNome() {
		Cliente cliente = clienteRepo.findByNome(cliDTO.getNome());
		
		return cliente;
	}
	/*
	public Cliente buscaSaldo() {
		Cliente cliente = clienteRepo.findByCpf(cliDTO.getSaldo());
		
		return cliente;
	}*/
	
	@GetMapping("logout")
	public String getLogout() {
		return "redirect:/";
	}
	
	@GetMapping("home/pix")
	public String getPix(String cpf, double valor) {
		Cliente clienteDestino = clienteRepo.findByCpf(cpf);
		
		if(clienteDestino == null){
			return "redirect:/home?chavepixinvalida";
		}

		Cliente clienteAtual = new Cliente(cliDTO.getNome(), cliDTO.getSenha(), cliDTO.getCpf(), cliDTO.getSaldo());
		clienteAtual.setSaldo(clienteAtual.getSaldo() - valor);
		clienteDestino.setSaldo(clienteDestino.getSaldo() + valor);
		
		return "redirect:/home?pixrealizado";
	}
}
