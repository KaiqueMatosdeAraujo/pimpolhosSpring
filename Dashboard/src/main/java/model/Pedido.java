package model;



public class Pedido {

	private Integer cod_pedido;
	private String nome_cliente;
	private String data_pedido;
	private Integer quantidade;
	private String descricao_frete;
	private String valor_frete;
	private String descricao_status_pedido;
	private Double valor_total;
	private Integer cod_cliente;
	private String nome_cidade;
	private String cep;
	private String nome_rua;
	private Integer numero_casa;
	private String complemento;
	private String bairro;
	private String ponto_referencia;
	private String descricao_estado;
	private String descricao_forma_pagamento;
	private String nome;
	private Double preco;
	private String nome_marca;	
//	private Boolean flag_endereco;
	private Integer cod_produto;
	private Integer qtdPedido;
	
	
	
	//Pedido
	public Pedido(String nome_cliente, String data_pedido, String descricao_status_pedido, Double valor_total) {
		this.nome_cliente = nome_cliente;
		this.data_pedido = data_pedido;
		this.descricao_status_pedido = descricao_status_pedido;
		this.valor_total = valor_total;
	}


	

	
	
	public Pedido(Integer cod_cliente ,String nome_cliente, String data_pedido, String descricao_frete,
			String descricao_status_pedido, String nome_cidade, String cep, String nome_rua, Integer numero_casa,
			String complemento, String bairro, String ponto_referencia, String descricao_estado,
			String descricao_forma_pagamento, Integer quantidade, Double total) {
		
		this.cod_cliente =cod_cliente;
		this.nome_cliente = nome_cliente;
		this.data_pedido = data_pedido;
		this.descricao_frete = descricao_frete;
		this.descricao_status_pedido = descricao_status_pedido;
		this.nome_cidade = nome_cidade;
		this.cep = cep;
		this.nome_rua = nome_rua;
		this.numero_casa = numero_casa;
		this.complemento = complemento;
		this.bairro = bairro;
		this.ponto_referencia = ponto_referencia;
		this.descricao_estado = descricao_estado;
		this.descricao_forma_pagamento = descricao_forma_pagamento;
		this.quantidade = quantidade;
		this.valor_total = total;
	
	}



	


	





	public Pedido(Integer quantidade, Double valor_total, String nome, Double preco, String nome_marca,
			Integer cod_produto,Integer cod_pedido) {
		super();
		this.quantidade = quantidade;
		this.valor_total = valor_total;
		this.nome = nome;
		this.preco = preco;
		this.nome_marca = nome_marca;
		this.cod_produto = cod_produto;
		this.cod_pedido= cod_pedido;
	}



	//Detalhe pedido
	
	
	

	//tabela da home
	public Pedido(String descricao_status_pedido, String descricao_forma_pagamento) {
	super();
	this.descricao_status_pedido = descricao_status_pedido;
	this.descricao_forma_pagamento = descricao_forma_pagamento;
}

	
	

	



	public Pedido(Integer qtdPedido) {
		super();
		this.qtdPedido = qtdPedido;
	}


	public Integer getCod_pedido() {
		return cod_pedido;
	}

	public void setCod_pedido(Integer cod_pedido) {
		this.cod_pedido = cod_pedido;
	}
	
	
//	public Integer getCod_detalhe() {
//		return cod_detalhe;
//	}
//
//	public void setCod_detalhe(Integer cod_detalhe) {
//		this.cod_detalhe = cod_detalhe;
//	}



	public String getNome_cliente() {
		return nome_cliente;
	}



	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}



	public String getData_pedido() {
		return data_pedido;
	}



	public void setData_pedido(String data_pedido) {
		this.data_pedido = data_pedido;
	}



	public Integer getQuantidade() {
		return quantidade;
	}



	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}



	public String getDescricao_frete() {
		return descricao_frete;
	}



	public void setDescricao_frete(String descricao_frete) {
		this.descricao_frete = descricao_frete;
	}



	public String getValor_frete() {
		return valor_frete;
	}



	public void setValor_frete(String valor_frete) {
		this.valor_frete = valor_frete;
	}



	public String getDescricao_status_pedido() {
		return descricao_status_pedido;
	}



	public void setDescricao_status_pedido(String descricao_status_pedido) {
		this.descricao_status_pedido = descricao_status_pedido;
	}



	public Double getValor_total() {
		return valor_total;
	}



	public void setValor_total(Double valor_total) {
		this.valor_total = valor_total;
	}


	public String getNome_cidade() {
		return nome_cidade;
	}


	public void setNome_cidade(String nome_cidade) {
		this.nome_cidade = nome_cidade;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getNome_rua() {
		return nome_rua;
	}


	public void setNome_rua(String nome_rua) {
		this.nome_rua = nome_rua;
	}


	public Integer getNumero_casa() {
		return numero_casa;
	}


	public void setNumero_casa(Integer numero_casa) {
		this.numero_casa = numero_casa;
	}


	public String getComplemento() {
		return complemento;
	}


	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getPonto_referencia() {
		return ponto_referencia;
	}


	public void setPonto_referencia(String ponto_referencia) {
		this.ponto_referencia = ponto_referencia;
	}


	public String getDescricao_estado() {
		return descricao_estado;
	}


	public void setDescricao_estado(String descricao_estado) {
		this.descricao_estado = descricao_estado;
	}


	public String getDescricao_forma_pagamento() {
		return descricao_forma_pagamento;
	}


	public void setDescricao_forma_pagamento(String descricao_forma_pagamento) {
		this.descricao_forma_pagamento = descricao_forma_pagamento;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}


	public String getNome_marca() {
		return nome_marca;
	}


	public void setNome_marca(String nome_marca) {
		this.nome_marca = nome_marca;
	}


	public Integer getCod_produto() {
		return cod_produto;
	}


	public void setCod_produto(Integer cod_produto) {
		this.cod_produto = cod_produto;
	}



	public Integer getQtdPedido() {
		return qtdPedido;
	}



	public void setQtdPedido(Integer qtdPedido) {
		this.qtdPedido = qtdPedido;
	}



	@Override
	public String toString() {
		return "" + qtdPedido;
	}



	public Integer getCod_cliente() {
		return cod_cliente;
	}



	public void setCod_cliente(Integer cod_cliente) {
		this.cod_cliente = cod_cliente;
	}



	
}
