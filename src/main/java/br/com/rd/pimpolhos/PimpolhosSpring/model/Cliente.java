package br.com.rd.pimpolhos.PimpolhosSpring.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="clientes")
public class Cliente implements UserDetails{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codCliente;
	
	@Column(nullable = false)
	@Size(max=50)
	private String nomeCliente;
	
	@Column(nullable = false)
	private String cpf;
	
	@Column(nullable = false)
	private String dataNasc;
	
	
	@Size(max=50)
	@Column(nullable = false)
	private String email;
	
	
	@Column(nullable = false)
	private String senha;
	
	
	@Size(max=3)
	@Column(nullable = false)
	private String ddd;
	
	@Size(max=9)
	@Column(nullable = false)
	private String numeroTelefone;

	@ManyToMany
	@JoinTable(
    name = "favoritos",
	joinColumns = @JoinColumn(name = "cod_cliente"),
	inverseJoinColumns = @JoinColumn(name = "cod_produto"))
	Set<Produto> produto;


//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(
//    name = "cliente_telefone",
//    joinColumns = {@JoinColumn(name = "cod_telefone")},
//    inverseJoinColumns = {@JoinColumn(name = "cod_cliente")})
//	private List<Telefone> telefone;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
    name = "endereco_cliente",
    joinColumns = {@JoinColumn(name = "cod_cliente")},
    inverseJoinColumns = {@JoinColumn(name = "cod_endereco")})
	private List<Endereco> endereco;
	
	@Fetch(FetchMode.SELECT)
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Perfil> perfis = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	List<Cartao> cartao;
	
	public Cliente() {
		
	}
	

	public Cliente(Integer codCliente, @Size(max = 50) String nomeCliente, String cpf,
			String dataNasc, @Size(max = 50) String email,  String senha, @Size(max = 3) String ddd,
			@Size(max = 9) String numeroTelefone, List<Endereco> endereco) {
		super();
		this.codCliente = codCliente;
		this.nomeCliente = nomeCliente;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.email = email;
		this.senha = senha;
		this.ddd = ddd;
		this.numeroTelefone = numeroTelefone;
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codCliente == null) ? 0 : codCliente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (codCliente == null) {
			if (other.codCliente != null)
				return false;
		} else if (!codCliente.equals(other.codCliente))
			return false;
		return true;
	}

	


	public Integer getCodCliente() {
		return codCliente;
	}


	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
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


	public String getDataNasc() {
		return dataNasc;
	}


	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getDdd() {
		return ddd;
	}


	public void setDdd(String ddd) {
		this.ddd = ddd;
	}


	public String getNumeroTelefone() {
		return numeroTelefone;
	}


	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}


	public Set<Produto> getProduto() {
		return produto;
	}


	public void setProduto(Set<Produto> produto) {
		this.produto = produto;
	}


	public List<Endereco> getEndereco() {
		return endereco;
	}


	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}


	public List<Perfil> getPerfis() {
		return perfis;
	}


	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}


	public List<Pedido> getPedidos() {
		return pedidos;
	}


	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}


	public List<Cartao> getCartao() {
		return cartao;
	}


	public void setCartao(List<Cartao> cartao) {
		this.cartao = cartao;
	}

	@Override public Collection<? extends GrantedAuthority> getAuthorities() { 
		return this.perfis; 
	} 

	public String getPassword() {
		// TODO Auto-generated method stub
		return this.senha;
	}


	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}

	
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
	
}
