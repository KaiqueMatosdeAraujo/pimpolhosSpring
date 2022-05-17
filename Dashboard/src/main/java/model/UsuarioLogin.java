package model;

public class UsuarioLogin {
	private Integer cod_usuario;
	private String  nome;
	private String  usuario;
	private String  senha;
	private Integer qtdUsuario;
	/**
	 * @param nome
	 * @param usuario
	 * @param senha
	 */
	public UsuarioLogin(String nome, String usuario, String senha) {
		super();
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
	}
	
	
	public UsuarioLogin(Integer qtdUsuario) {
		super();
		this.qtdUsuario = qtdUsuario;
	}
	
	public UsuarioLogin() {
		
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Integer getCod_usuario() {
		return cod_usuario;
	}
	public void setCod_usuario(Integer cod_usuario) {
		this.cod_usuario = cod_usuario;
	}


	public Integer getQtdUsuario() {
		return qtdUsuario;
	}


	public void setQtdUsuario(Integer qtdUsuario) {
		this.qtdUsuario = qtdUsuario;
	}


	@Override
	public String toString() {
		return "" + qtdUsuario;
	}
	
	
	
	
}
