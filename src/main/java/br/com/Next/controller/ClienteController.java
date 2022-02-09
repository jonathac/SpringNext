package br.com.Next.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.Next.bean.Cliente;
import br.com.Next.bo.ClienteBo;
import br.com.Next.dto.ClienteDTO;
import br.com.Next.repositories.ClienteRepository;

@Controller
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	private ClienteDTO cliDTO;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getIndex(Model model) {
		ClienteDTO cliDTO = new ClienteDTO();
		model.addAttribute("clienteDTO", cliDTO);
		return "index";
	}

	public ClienteBo getClienteBo() {
		return new ClienteBo(this.clienteRepository);
	}

	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public String getCadastro(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);

		return "cadastro";
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public String insertCliente(Cliente cliente) {
		/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {

			cliente.setData(sdf.parse(cliente.getDataString()));
		} catch (ParseException e) {
		}*/

		ClienteBo cliBO = this.getClienteBo();
		cliBO.inserirCliente(cliente);

		return "redirect:/?inseriu=true";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(ClienteDTO clienteDTO) {
		Cliente cli = clienteRepository.findByCpfAndSenha(clienteDTO.getCpf(), clienteDTO.getSenha());
		
		if(cli == null) {
			return "redirect:/?logininvalido";
		}
		
		clienteDTO.setNome(cli.getNome());
		cliDTO = clienteDTO;
		
		return "home";
	}
	
	@RequestMapping(value = "/extrato", method = RequestMethod.GET)
	public String getExtrato() {
		return "extrato";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHome() {
		return "home";
	}
}
