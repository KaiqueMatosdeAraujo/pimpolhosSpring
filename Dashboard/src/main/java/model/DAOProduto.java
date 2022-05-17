package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOProduto {

	public DAOProduto() {
	
	}
	public void inserirProduto (Produto produto) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement
					("insert into produto (nome, preco, dimensao, material, peso, conteudo_produto, cod_fornecedor, cod_categoria, img_produto, cod_marca) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			p.setString(1, produto.getNome());
		    p.setDouble(2, produto.getPreco());
		    p.setString(3, produto.getDimensao());
		    p.setString(4, produto.getMaterial());
			p.setDouble(5, produto.getPeso());
		    p.setString(6, produto.getConteudo_produto());
		    p.setInt(7, produto.getCod_fornecedor());
			p.setInt(8, produto.getCod_categoria());
			p.setString(9, produto.getImg_produto());
			p.setInt(10, produto.getCod_marca());
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Produto> exibirProduto(){
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		ArrayList<Produto> lista = new ArrayList<Produto>();
		try {
			PreparedStatement p = con.prepareStatement("select produto.cod_produto, produto.nome, produto.preco, produto.dimensao, produto.material, produto.peso, produto.conteudo_produto , f.nome_fornecedor, c.nome_categoria, produto.img_produto, m.nome_marca from produto\r\n"
					+ "inner join fornecedor f on f.cod_fornecedor = produto.cod_fornecedor \r\n"
					+ "inner join categoria c on c.cod_categoria = produto.cod_categoria \r\n"
					+ "inner join marca m on m.cod_marca = produto.cod_marca ORDER BY cod_produto ASC;");
			ResultSet r = p.executeQuery();			
			
			while (r.next()) {
				Integer id = r.getInt("cod_produto");
				String nome = r.getString("nome");
				Double preco = r.getDouble("preco");
				String dimensao = r.getString("dimensao");
				String material = r.getString("material");
				Double peso = r.getDouble ("peso");
				String conteudo = r.getString("conteudo_produto");
				String fornecedor = r.getString("nome_fornecedor");
				String categoria = r.getString("nome_categoria");
				String img_produto = r.getString("img_produto");
				String cod_marca = r.getString("nome_marca");
				Produto produto = new Produto(nome, preco, dimensao, material, peso, conteudo, fornecedor, categoria, img_produto, cod_marca);
				produto.setCod_produto(id);
				lista.add(produto);
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
	
	public void deletarProduto(Integer cod_produto) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("delete from produto where cod_produto = ?");
			p.setInt(1,cod_produto);
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void atualizarProduto(Produto produto) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("update produto set nome = ? , preco = ?, dimensao = ?, material = ?, peso = ?, conteudo_produto = ?, cod_fornecedor = ?, cod_categoria = ?, img_produto = ?, cod_marca = ?  where cod_produto = ? ");
			p.setString(1, produto.getNome());
			p.setDouble(2, produto.getPreco());
			p.setString(3, produto.getDimensao());
			p.setString(4, produto.getMaterial());
			p.setDouble(5, produto.getPeso());
			p.setString(6, produto.getConteudo_produto());
			p.setInt(7, produto.getCod_fornecedor());
			p.setInt(8, produto.getCod_categoria());
			p.setString(9, produto.getImg_produto());
			p.setInt(10, produto.getCod_marca());
			
			p.setInt(11, produto.getCod_produto());
			
			
			
			
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Produto recuperarProduto (Integer id) {	
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		Produto u = null;
		try {
			PreparedStatement p = con.prepareStatement("select * from produto where cod_produto = ?");
			p.setInt(1,  id);
			ResultSet r = p.executeQuery();			
			
			
			while (r.next()) {
				Integer cod_produto = r.getInt("cod_produto");
				String nome = r.getString("nome");
				Double preco = r.getDouble("preco");

				String dimensao = r.getString("dimensao");
				String material = r.getString("material");
				Double peso = r.getDouble ("peso");
				String conteudo = r.getString ("conteudo_produto");
				Integer fornecedor = r.getInt("cod_fornecedor");
				Integer categoria = r.getInt("cod_categoria");
				String img_produto = r.getString ("img_produto");
				Integer cod_marca = r.getInt("cod_marca");
				u = new Produto(nome, preco, dimensao, material, peso, conteudo, fornecedor, categoria, img_produto, cod_marca);
				u.setCod_produto(cod_produto);
			}
			r.close();
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	
	
	
	//M�todo de conta da home
			public Produto qtdProdutoTotal() {	
			Conexao c = Conexao.getInstance();
			Connection con = c.getConnection();
			Produto qtdTotalProduto = null;
			
			
				try {
					PreparedStatement p = con.prepareStatement("select count(cod_produto) as total from produto;");
					ResultSet r = p.executeQuery();			
					 r.next();
					
					
					Integer qtdProduto = r.getInt("total");
					qtdTotalProduto = new Produto(qtdProduto);
					qtdTotalProduto.setQtdProduto(qtdProduto);
				
						
					
					r.close();
					p.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return qtdTotalProduto;
			}
	

}
