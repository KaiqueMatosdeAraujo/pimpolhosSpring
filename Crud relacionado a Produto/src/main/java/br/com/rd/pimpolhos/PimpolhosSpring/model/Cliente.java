package br.com.rd.pimpolhos.PimpolhosSpring.model;

import java.time.LocalDate;
import java.util.Date;

import java.util.List;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;


import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name="cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codCliente;
	
	@Column(nullable = false)
	@Size(max=50)
	private String nomeCliente;
	
	@Column(nullable = false)
	@Size(max=11)
	private String cpf;
	
	@Column(nullable = false)
	private LocalDate dataNasc;
	
	@Size(max=50)
	@Column(nullable = false)
	private String email;
	
	@Size(max=50)
	@Column(nullable = false)
	private String senha;
	

	@ManyToMany
	@JoinTable(
    name = "favoritos",
	joinColumns = @JoinColumn(name = "cod_Produto"),
	inverseJoinColumns = @JoinColumn(name = "cod_Cliente"))
	Set<Produto> produto;

	@ManyToMany 
	@JoinTable(
    name = "cliente_telefone",
    joinColumns = {@JoinColumn(name = "cod_telefone")},
    inverseJoinColumns = {@JoinColumn(name = "cod_cliente")})
	private Set<Telefone> telefone;
	

	@ManyToMany (fetch = FetchType.EAGER)
	@JoinTable(
    name = "endereco_cliente",
    joinColumns = {@JoinColumn(name = "cod_cliente")},
    inverseJoinColumns = {@JoinColumn(name =  "cod_endereco")})
	private Set<Endereco> endereco;
	
	
	
	
	public Set<Produto> getProduto() {
		return produto;
	}

	public void setProduto(Set<Produto> produto) {
		this.produto = produto;
	}

	public Set<Telefone> getTelefone() {
		return telefone;
	}

	public void setTelefone(Set<Telefone> telefone) {
		this.telefone = telefone;
	}

	public Cliente() {
		
	}
	
	

	public Cliente(@Size(max = 50) String nomeCliente, @Size(max = 11) String cpf, LocalDate dataNasc,
			@Size(max = 50) String email, @Size(max = 50) String senha, Set<Telefone> telefone,
			Set<Endereco> endereco) {
		super();
		this.nomeCliente = nomeCliente;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.endereco = endereco;
	}
	
	

	public Integer getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Cliente [nomeCliente=" + nomeCliente + ", cpf=" + cpf + ", dataNasc=" + dataNasc + ", email=" + email
				+ ", senha=" + senha + ", endereco=" + endereco + "]";
	}

	
	

	
}