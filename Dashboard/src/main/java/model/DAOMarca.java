package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

public class DAOMarca {

	public DAOMarca() {
		
	}
	
	
//                                           Marca
	
	public void inserirMarca (Marca marca) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("insert into marca (nome_marca) VALUES (?)");
			
			p.setString(1, marca.getNome_marca());
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			
			p.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public ArrayList<Marca> exibirMarca(){
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		ArrayList<Marca> lista = new ArrayList<Marca>();
		try {
			PreparedStatement p = con.prepareStatement("select * from marca");
			ResultSet r = p.executeQuery();			
			
			while (r.next()) {
				Integer cod_marca= r.getInt("cod_marca");
				String nome = r.getString("nome_marca");
				Marca marca = new Marca(nome);
				marca.setCod_marca(cod_marca);
				
				lista.add(marca);
			}
			
			r.close();
			p.close();
			con.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public void deletarMarca(Integer cod_marca) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("delete from marca where cod_marca = ?");
			p.setInt(1, cod_marca);
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			
			p.close();
			con.close();
			
		} catch (SQLException e) {
			System.out.println("Não foi possível apagar essa marca");
			e.printStackTrace();
		}
	}
	
	
	public void atualizarMarca(Marca marca) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("update marca set nome_marca = ?  where cod_marca = ? ");
			p.setString(1, marca.getNome_marca());
			p.setInt(2, marca.getCod_marca());
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			
			p.close();
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Marca recuperarMarca (Integer cod_marca) {	
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		Marca u = null;
		
		try {
			PreparedStatement p = con.prepareStatement("select * from marca where cod_marca = ?");
			p.setInt(1, cod_marca);
			ResultSet r = p.executeQuery();			
			
			
			while (r.next()) {
				Integer id1 = r.getInt("cod_marca");
				String nome = r.getString("nome_marca");

				u = new Marca(nome);
				u.setCod_marca(id1);
			}
			r.close();
			p.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
}
