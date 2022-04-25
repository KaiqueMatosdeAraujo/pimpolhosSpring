package br.com.rd.pimpolhos.PimpolhosSpring.model;

import java.time.LocalDate;
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


@Entity
@Table(name="clientes")
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
	
	private Boolean ativo;
	
	@ManyToMany
	@JoinTable(
    name = "favoritos",
	joinColumns = @JoinColumn(name = "cod_Produto"),
	inverseJoinColumns = @JoinColumn(name = "cod_Cliente"))
	Set <Produto> produto;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
    name = "cliente_telefone",
    joinColumns = {@JoinColumn(name = "cod_telefone")},
    inverseJoinColumns = {@JoinColumn(name = "cod_cliente")})
	private Set<Telefone> telefone;
	

	
	public Cliente() {
		
	}

	
	
	
	
	public Cliente(@Size(max = 50) String nomeCliente, @Size(max = 11) String cpf, LocalDate dataNasc,
			@Size(max = 50) String email, @Size(max = 50) String senha, Set<Telefone> telefone) {
		super();
		this.nomeCliente = nomeCliente;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
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
	
	

	public Boolean getAtivo() {
		return ativo;
	}



	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}





	@Override
	public String toString() {
		return "Cliente [codCliente=" + codCliente + ", nomeCliente=" + nomeCliente + ", cpf=" + cpf + ", dataNasc="
				+ dataNasc + ", email=" + email + ", senha=" + senha + ", ativo=" + ativo + ", telefone=" + telefone
				+ "]";
	}




	

	
}
