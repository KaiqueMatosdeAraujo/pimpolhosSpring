package model;



public class Usuario {

	private Integer cod_cliente;
	private String  nome;
	private String  cpf;
	private String  nascimento;
	private String  email;
	private String  rua;
	private String numeroCasa;
	private String cep;
	private String complemento;
	private String pontoReferencia;
	private String bairro;
	private String cidade;
	private String estado;
	private String nCartao;
	private String   val;
	private String bandeira;
	private String titularCartao;
	private String dddtelefone;
	private String telefoneCliente;
	private String tipoTelefone;
	private int qtdCliente;
	private Integer qtdPedido;
	private String qtdProduto;
	


	public Usuario(Integer cod_cliente,String titularCartao, String nCartao, String val, String bandeira ) {
		super();
		this.cod_cliente = cod_cliente;
		this.nCartao = nCartao;
		this.val = val;
		this.bandeira = bandeira;
		this.titularCartao = titularCartao;
	}



	public Usuario(Integer cod_cliente, String dddtelefone, String telefoneCliente, String tipoTelefone) {
		super();
		this.cod_cliente = cod_cliente;
		this.dddtelefone = dddtelefone;
		this.telefoneCliente = telefoneCliente;
		this.tipoTelefone = tipoTelefone;
	}



	// CLIENTE PADR�O
	public Usuario(String nome, String cpf, String nascimento, String email) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.nascimento = nascimento;
		this.email = email;
	}

	
//public Usuario(int qtdCliente, Integer qtdPedido, String qtdProduto) {
//		super();
//		this.qtdCliente = qtdCliente;
//		this.qtdPedido = qtdPedido;
//		this.qtdProduto = qtdProduto;
//	}






// Endereco

	public Usuario(String rua, String numeroCasa, String cep, String complemento, String pontoReferencia, String bairro,
			String cidade, String estado) {
		super();
		this.rua = rua;
		this.numeroCasa = numeroCasa;
		this.cep = cep;
		this.complemento = complemento;
		this.pontoReferencia = pontoReferencia;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		
	}



	public Usuario(int qtdCliente) {
		super();
		this.qtdCliente = qtdCliente;
	}


	
	public Usuario(Integer qtdPedido) {
		super();
		this.qtdPedido = qtdPedido;
	}


	public Usuario(String qtdProduto) {
		super();
		this.qtdProduto = qtdProduto;
	}


	public Integer getCod_cliente() {
		return cod_cliente;
	}


	public void setCod_cliente(Integer cod_cliente) {
		this.cod_cliente = cod_cliente;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public String getVal() {
		return val;
	}



	public void setVal(String val) {
		this.val = val;
	}



	public String getNascimento() {
		return nascimento;
	}



	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getRua() {
		return rua;
	}


	public void setRua(String rua) {
		this.rua = rua;
	}


	public String getNumeroCasa() {
		return numeroCasa;
	}


	public void setNumeroCasa(String numeroCasa) {
		this.numeroCasa = numeroCasa;
	}



	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}



	public String getComplemento() {
		return complemento;
	}



	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}



	public String getPontoReferencia() {
		return pontoReferencia;
	}



	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}



	public String getBairro() {
		return bairro;
	}



	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCidade() {
		return cidade;
	}



	public void setCidade(String cidade) {
		this.cidade = cidade;
	}



	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getBandeira() {
		return bandeira;
	}


	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}


	public String getTitularCartao() {
		return titularCartao;
	}



	public void setTitularCartao(String titularCartao) {
		this.titularCartao = titularCartao;
	}


	public String getDddtelefone() {
		return dddtelefone;
	}


	public void setDddtelefone(String dddtelefone) {
		this.dddtelefone = dddtelefone;
	}



	public String getTelefoneCliente() {
		return telefoneCliente;
	}



	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}


	public String getTipoTelefone() {
		return tipoTelefone;
	}



	public void setTipoTelefone(String tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}


	public String getnCartao() {
		return nCartao;
	}



	public void setnCartao(String nCartao) {
		this.nCartao = nCartao;
	}






	public int getQtdCliente() {
		return qtdCliente;
	}








	public void setQtdCliente(int qtdCliente) {
		this.qtdCliente = qtdCliente;
	}








	public Integer getQtdPedido() {
		return qtdPedido;
	}








	public void setQtdPedido(Integer qtdPedido) {
		this.qtdPedido = qtdPedido;
	}








	public String getQtdProduto() {
		return qtdProduto;
	}



	public void setQtdProduto(String qtdProduto) {
		this.qtdProduto = qtdProduto;
	}




	@Override
	public String toString() {
		return ""+ this.qtdCliente;
	}



}