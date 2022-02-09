package br.com.Next.dto;

public class ClienteDTO {
	private String cpf;
	private String senha;
	private String nome;
	private Double saldo;
	
	public ClienteDTO() {}
	
	public ClienteDTO(String cpf, String senha, String nome, Double saldo) {
		super();
		this.cpf = cpf;
		this.senha = senha;
		this.nome = nome;
		this.saldo = saldo;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	
}
