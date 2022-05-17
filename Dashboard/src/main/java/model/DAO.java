package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {

	public DAO() {
		
	}
	
	// ------------------------------------------- CLIENTE -----------------------------------------------------------------

	public ArrayList<Usuario> exibirUsuarios(){
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		try {
			PreparedStatement p = con.prepareStatement("select cliente.cod_cliente ,cliente.nome_cliente, cliente.cpf,cliente.data_nasc ,cliente.email from cliente");
			ResultSet r = p.executeQuery();			
			
			while (r.next()) {
				Integer id = r.getInt("cod_cliente");
				String nome = r.getString("nome_cliente");
				String cpf = r.getString("cpf");
				String data = r.getString("data_nasc");
				String email = r.getString("email");
				Usuario usuario = new Usuario(nome, cpf, data, email);
				usuario.setCod_cliente(id);
				lista.add(usuario);
			}
			r.close();
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	public ArrayList<Usuario> recuperarDetalhesClienteCartao (Integer id) {	
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		Usuario detalhes = null;
		ArrayList<Usuario> listDetalhesCartao = new ArrayList<Usuario>();
		try {
			PreparedStatement p = con.prepareStatement("select c2.cod_cliente,c.nome_titular,c.numero_cartao ,c.validade,b.descricao_bandeira from cartao c \r\n"
					+ "inner join cliente c2 on c2.cod_cliente = c.cod_cliente \r\n"
					+ "inner join bandeira b on b.cod_bandeira = c.cod_bandeira \r\n"
					+ "where c2.cod_cliente = ? ");
			p.setInt(1, id);
			ResultSet r = p.executeQuery();			
			
			
			while (r.next()) {
				 Integer cliente = r.getInt("cod_cliente");
				 String titularCartao = r.getString("nome_titular");
				 String numeroCartao = r.getString("numero_cartao");
				 String validade = r.getString ("validade");
			     String bandeira = r.getString("descricao_bandeira");
			     
			     Usuario detalheclienteCartao = new Usuario(cliente, titularCartao, numeroCartao, validade, bandeira);
			     detalheclienteCartao.setCod_cliente(cliente);
			     listDetalhesCartao.add(detalheclienteCartao);
			}
			r.close();
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listDetalhesCartao;
	}
	
	public ArrayList<Usuario> recuperarDetalhesClienteTelefone (Integer id) {	
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		Usuario detalhes = null;
		ArrayList<Usuario> listDetalhesTelefone = new ArrayList<Usuario>();
		try {
			PreparedStatement p = con.prepareStatement("select c.cod_cliente,t.ddd ,t.numero_telefone ,t.descricao_telefone from telefone t \r\n"
					+ "inner join cliente_telefone ct on ct.cod_telefone = t.cod_telefone \r\n"
					+ "inner join cliente c on c.cod_cliente = ct.cod_cliente \r\n"
					+ "where c.cod_cliente = ?");
			p.setInt(1, id);
			ResultSet r = p.executeQuery();			
			
			
			while (r.next()) {
				 Integer cliente = r.getInt("cod_cliente");
			     String ddd = r.getString("ddd");
			     String telefone = r.getString("numero_telefone");
			     String descricaotelefone = r.getString("descricao_telefone");
			     
			     Usuario detalheclienteT = new Usuario(cliente, ddd, telefone, descricaotelefone);
			     detalheclienteT.setCod_cliente(cliente);
			     listDetalhesTelefone.add(detalheclienteT);
			}
			r.close();
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listDetalhesTelefone;
	}
	
	
	public ArrayList<Usuario> recuperarInfoEnderecoCliente (Integer id) {	
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		Usuario detalhes = null;
		ArrayList<Usuario> listEnderecoC = new ArrayList<Usuario>();
		try {
			PreparedStatement p = con.prepareStatement("select c.cod_cliente,e.nome_rua ,e.numero_casa,e.complemento ,e.ponto_referencia ,e.bairro,e.cep,e.nome_cidade,e2.descricao_estado from endereco e \r\n"
					+ "inner join endereco_cliente ec on ec.cod_endereco = e.cod_endereco \r\n"
					+ "inner join cliente c ON c.cod_cliente = ec.cod_cliente \r\n"
					+ "inner join estado e2 on e2.cod_estado = e.cod_estado \r\n"
					+ "where c.cod_cliente = ?\r\n"
					+ ";");
			p.setInt(1, id);
			ResultSet r = p.executeQuery();			
			
			
			while (r.next()) {
				 Integer cliente = r.getInt("cod_cliente");
				 String rua = r.getString("nome_rua");
				 String numeroCasa = r.getString("numero_casa");
				 String bairro = r.getString("bairro");
				 String complemento = r.getString("complemento");
				 String ptReferencia = r.getString("ponto_referencia");
				 String cep = r.getString("cep");
				 String cidade = r.getString("nome_cidade");
				 String estado = r.getString("descricao_estado");
			     
			     Usuario detalheEnderecoC = new Usuario(rua, numeroCasa, cep, complemento, ptReferencia, bairro, cidade, estado); 
			     detalheEnderecoC.setCod_cliente(cliente);
			     listEnderecoC.add(detalheEnderecoC);
			}
			r.close();
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listEnderecoC;
	}
	
	public ArrayList<Usuario> recuperarInfoPrincipalCliente (Integer id) {	
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		Usuario info = null;
		ArrayList<Usuario> infoCliente = new ArrayList<Usuario>();
		try {
			PreparedStatement p = con.prepareStatement("select cliente.cod_cliente,cliente.nome_cliente,cliente.cpf,cliente.data_nasc,cliente.email from cliente \r\n"
					+ "where cliente.cod_cliente = ?");
			p.setInt(1, id);
			ResultSet r = p.executeQuery();			
			
			
			while (r.next()) {
				 Integer clienteCod = r.getInt("cod_cliente");
				 String nomecliente = r.getString("nome_cliente");
				 String cpf = r.getString("cpf");
				 String nasc = r.getString ("data_nasc");
				 String email = r.getString("email") ;
			     
			     Usuario infoClientePrincipal = new Usuario(nomecliente, cpf, nasc, email); 
			     infoClientePrincipal.setCod_cliente(clienteCod);
			     infoCliente.add(infoClientePrincipal);
			}
			r.close();
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return infoCliente;
	}
	
	
	//M�todo de conta da home
		public Usuario qtdClienteTotal () {	
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		Usuario qtd = null;
		
		
			try {
				PreparedStatement p = con.prepareStatement("select count(cod_cliente) as total from cliente;");
				ResultSet r = p.executeQuery();			
				 r.next();
				
				
				Integer qtdClientes = r.getInt("total");
				qtd = new Usuario(qtdClientes);
				qtd.setQtdCliente(qtdClientes);
			
					
				
				r.close();
				p.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return qtd;
		}	
	
	
		
		
		
		
		public static List<Usuario> getRecords(int start, int total){
			List<Usuario> list = new ArrayList<Usuario>();
			
			try {
				Conexao c = Conexao.getInstance();
				Connection con = c.getConnection();
				PreparedStatement p = con.prepareStatement("select * from LIMIT " + (start) + ", " + total);
				ResultSet r = p.executeQuery();	
				
				while (r.next()) {
					Integer id = r.getInt("cod_cliente");
					String nome = r.getString("nome_cliente");
					String cpf = r.getString("cpf");
					String data = r.getString("data_nasc");
					String email = r.getString("email");
					Usuario usuario = new Usuario(nome, cpf, data, email);
					usuario.setCod_cliente(id);
					list.add(usuario);
				}
				r.close();
				p.close();
				con.close();
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		}
		
		
		
		
		
		
	
	
//---------- PEDIDO ------------------------------------------------------------------
	
		public ArrayList<Pedido> exibirPedido(){
			Conexao c = Conexao.getInstance();
			Connection con = c.getConnection();
			ArrayList<Pedido> listaPedido = new ArrayList<Pedido>();
			try {
				PreparedStatement p = con.prepareStatement("select pedido.cod_pedido, c.nome_cliente, pedido.data_pedido, sp.descricao_status_pedido, sum(ip.quantidade * p.preco + f.valor_frete) as valor_total  from pedido\r\n"
						+ "inner join cliente c on c.cod_cliente = pedido.cod_cliente\r\n"
						+ "inner join item_pedido ip on ip.cod_item_pedido = pedido.cod_item_pedido\r\n"
						+ "inner join frete f on f.cod_frete = pedido.cod_frete\r\n"
						+ "inner join status_pedido sp on sp.cod_status = pedido.cod_status\r\n"
						+ "inner join produto p on p.cod_produto = ip.cod_produto \r\n"
						+ "group by pedido.cod_pedido, c.nome_cliente, pedido.data_pedido, sp.descricao_status_pedido\r\n"
						+ "ORDER BY cod_pedido ASC"
						+ "");
				ResultSet r = p.executeQuery();			
				
				while (r.next()) {
					Integer id = r.getInt("cod_pedido");
					String nomeCliente = r.getString("nome_cliente");
					String data_pedido = r.getString("data_pedido");
					String status= r.getString("descricao_status_pedido");
					Double valor_total = r.getDouble("valor_total");
					
					
					Pedido pedido = new Pedido(nomeCliente, data_pedido, status, valor_total);
					pedido.setCod_pedido(id);
					listaPedido.add(pedido);
				}
				r.close();
				p.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return listaPedido;
		}
		

//		public Pedido recuperarPedido (Integer id) {	
//			Conexao c = Conexao.getInstance();
//			Connection con = c.getConnection();
//			Pedido pedido = null;
//			try {
//				PreparedStatement p = con.prepareStatement("select * from pedido where cod_pedido = ?");
//				p.setInt(1, id);
//				ResultSet r = p.executeQuery();			
//				
//				
//				while (r.next()) {
//					Integer id1 = r.getInt("cod_pedido");
//					String nomeCliente = r.getString("nome_cliente");
//					String data_pedido = r.getString("data_pedido");
//					Integer quantidade = r.getInt("quantidade");
//					String frete= r.getString("descricao_frete");
//					String valor_frete = r.getString("valor_frete");
//					String status= r.getString("descricao_status_pedido");
//					Double valor_total = r.getDouble("valor_total");
//					//Boolean flagEND= r.getBoolean("flag_endereco");
//					pedido = new Pedido(nomeCliente, data_pedido, quantidade, frete, valor_frete, status, valor_total);
//					pedido.setCod_pedido(id1);
//				}
//				r.close();
//				p.close();
//				con.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return pedido;
//		}
		
		
//		Detalhe do Pedido Padr�o
	
		
		
		
		
		public ArrayList<Pedido> recuperarDetalhePedido (Integer id) {	
			Conexao c = Conexao.getInstance();
			Connection con = c.getConnection();
			Pedido pedido = null;
			ArrayList<Pedido> listaItemDetalhePedido = new ArrayList<Pedido>();
			
			try {
				PreparedStatement p = con.prepareStatement("select pedido.cod_pedido,c.cod_cliente,"
						+ " pedido.data_pedido, "
						+ "c.nome_cliente,"
						+ " e.nome_cidade,\r\n"
						+ "e.cep, e.nome_rua, e.numero_casa, e.complemento, e.bairro, e.ponto_referencia,\r\n"
						+ "e2.descricao_estado, f.descricao_frete, sp.descricao_status_pedido, fp.descricao_forma_pagamento,\r\n"
						+ "SUM(ip.quantidade) as quantidade,\r\n"
						+ "SUM(ip.quantidade * p.preco + f.valor_frete) as valor_total from pedido\r\n"
						+ "inner join cliente c on c.cod_cliente = pedido.cod_cliente\r\n"
						+ "inner join endereco e on e.cod_endereco = pedido.cod_endereco\r\n"
						+ "inner join estado e2 on e2.cod_estado = e.cod_estado\r\n"
						+ "inner join frete f on f.cod_frete = pedido.cod_frete\r\n"
						+ "inner join status_pedido sp on sp.cod_status = pedido.cod_status\r\n"
						+ "inner join forma_pagamento fp on fp.cod_forma_pagamento = pedido.cod_forma_pagamento\r\n"
						+ "inner join item_pedido ip on ip.cod_item_pedido = pedido.cod_item_pedido \r\n"
						+ "inner join produto p  on p.cod_produto = ip.cod_produto \r\n"
						+ "where cod_pedido = ? ");
				p.setInt(1, id);
				ResultSet r = p.executeQuery();			
				
				
				while (r.next()) {
					
					Integer id1 = r.getInt("cod_pedido");
					Integer idCliente = r.getInt("cod_cliente");
					String nomeCliente = r.getString("nome_cliente");
					String data_pedido = r.getString("data_pedido");
		
					String nome_cidade = r.getString("nome_cidade");
					String cep = r.getString("cep");
					String nome_rua = r.getString("nome_rua");
					Integer numero_casa = r.getInt("numero_casa");
					String complemento = r.getString("complemento");
					String bairro = r.getString("bairro");
					String ponto_referencia = r.getString("ponto_referencia");
					String descricao_estado = r.getString("descricao_estado");
					String frete= r.getString("descricao_frete");
					String status= r.getString("descricao_status_pedido");
					String descricao_forma_pagamento = r.getString("descricao_forma_pagamento");
					Integer quantidadeItens = r.getInt("quantidade");
					Double valorTotal = r.getDouble("valor_total");
					

					Pedido itemPedido = new Pedido(idCliente, nomeCliente, 
							data_pedido, frete,
							status, nome_cidade, cep, nome_rua, 
							numero_casa, complemento, bairro, ponto_referencia, 
							descricao_estado, descricao_forma_pagamento, quantidadeItens, valorTotal);
					
					
					itemPedido.setCod_pedido(id1);
					listaItemDetalhePedido.add(itemPedido);
				}
				r.close();
				p.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return listaItemDetalhePedido;
		}
		
		public ArrayList<Pedido> recuperarItemPedido (Integer id) {	
			Conexao c = Conexao.getInstance();
			Connection con = c.getConnection();
			Pedido pedido = null;
			ArrayList<Pedido> listaItemPedido = new ArrayList<Pedido>();
			try {
				PreparedStatement p = con.prepareStatement("select pedido.cod_pedido,  p.nome, p.preco, m.nome_marca, ip.quantidade,"
						+ "(ip.quantidade * p.preco) as valor_total_item, p.cod_produto from pedido\r\n"
						+ "inner join item_pedido ip on ip.cod_item_pedido = pedido.cod_item_pedido\r\n"
						+ "inner join produto p on p.cod_produto = ip.cod_produto\r\n"
						+ "inner join marca m on m.cod_marca = p.cod_marca\r\n"
						+ "where pedido.cod_pedido = ?");
				p.setInt(1, id);
				ResultSet r = p.executeQuery();			
				while (r.next()) {
					Integer id1 = r.getInt("cod_pedido");
					String nome = r.getString("nome");
					Double preco = r.getDouble("preco");
					String nome_marca = r.getString("nome_marca");
					Integer quantidade = r.getInt("quantidade");
					Double valor_total = r.getDouble("valor_total_item");
					Integer cod_produto = r.getInt("cod_produto");

					Pedido itemPedido = new Pedido(quantidade, valor_total, nome, preco, nome_marca, cod_produto, id1);
					itemPedido.setCod_pedido(id1);
					listaItemPedido.add(itemPedido);
				}
				r.close();
				p.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return listaItemPedido;
		}
		
		
		
		
//      Fim Detalhe Pedido Padrão
		
		//Método de conta da home
			public Pedido qtdPedidoTotal () {	
			Conexao c = Conexao.getInstance();
			Connection con = c.getConnection();
			Pedido qtdTotalPedido = null;
			
			
				try {
					PreparedStatement p = con.prepareStatement("select count(cod_pedido) as total from pedido;");
					ResultSet r = p.executeQuery();			
					 r.next();
					
					
					Integer qtdPedido = r.getInt("total");
					qtdTotalPedido = new Pedido(qtdPedido);
					qtdTotalPedido.setQtdPedido(qtdPedido);
				
						
					
					r.close();
					p.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return qtdTotalPedido;
			}
			
			
			
			
			
			
			public ArrayList<Pedido> exibirPedidosRecentes(){
				Conexao c = Conexao.getInstance();
				Connection con = c.getConnection();
				ArrayList<Pedido> listaPedidosRecentes = new ArrayList<Pedido>();
				try {
					PreparedStatement p = con.prepareStatement("select p.cod_pedido, fp.descricao_forma_pagamento, sp.descricao_status_pedido from pedido p \r\n"
							+ "inner join forma_pagamento fp on fp.cod_forma_pagamento = p.cod_forma_pagamento \r\n"
							+ "inner join status_pedido sp on sp.cod_status = p.cod_status \r\n"
							+ "where data_pedido between ('10012022') and ('16012023')"
							+ "");
					ResultSet r = p.executeQuery();			
					
					while (r.next()) {
						Integer id = r.getInt("cod_pedido");
						String descricao_forma_pagamento = r.getString("descricao_forma_pagamento");
						String status= r.getString("descricao_status_pedido");
						
						Pedido pedido = new Pedido(descricao_forma_pagamento, status);
						pedido.setCod_pedido(id);
						listaPedidosRecentes.add(pedido);
					}
					r.close();
					p.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return listaPedidosRecentes;
			}
}