package br.com.Next.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="cliente") // nome da tabelda db
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "cliente_id_cliente_seq")
	@SequenceGenerator(name = "", sequenceName = "", allocationSize = 1)
	@Column(name = "id_cliente")
	private Integer idCliente;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "data_nascimento")
	private Date data;
	
	@Column(name = "senha")
	private String senha;
	
	@Column(name = "cpf")
	private Integer cpf;

	
	
	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}
	
	
	
}
