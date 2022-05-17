package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import at.favre.lib.crypto.bcrypt.BCrypt;


public class DAOLoginCadastrar {
	
	
	public DAOLoginCadastrar() {
		
	}
	
	//criptografia
//	public String codificarSenha(String senha) {
//        return BCrypt.withDefaults().hashToString(12, senha.toCharArray());
//        
//    }
	
	//descriptografia
//	public boolean validarSenha(String senha, String senhaCrypto) {
//        BCrypt.Result response = BCrypt.verifyer().verify(senha.toCharArray(), senhaCrypto);
//        return response.verified;
//    }


	
	public void inserirUsuario(UsuarioLogin usuario) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("insert into login (nome , usuario , senha) VALUES (? , ? , ?)");
			p.setString(1, usuario.getNome());
			p.setString(2, usuario.getUsuario());
			p.setString(3, usuario.getSenha());
		   
			
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
	
	
	public ArrayList<UsuarioLogin> exibirUsuarioLogin(){
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		ArrayList<UsuarioLogin> lista = new ArrayList<UsuarioLogin>();
		try {
			PreparedStatement p = con.prepareStatement("select * from login");
			ResultSet r = p.executeQuery();			
			
			while (r.next()) {
				String nome = r.getString("nome");
				String nome_usuario = r.getString("usuario");
				String senha = r.getString("senha");
				Integer cod_usuario = r.getInt("cod_usuario");
			     
				UsuarioLogin usuario = new UsuarioLogin(nome , nome_usuario , senha);
				usuario.setCod_usuario(cod_usuario);
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
	
	
	//M�todo de conta da home
	public UsuarioLogin qtdUsuarioTotal () {	
	Conexao c = Conexao.getInstance();
	Connection con = c.getConnection();
	UsuarioLogin qtdUsuarioTotal = null;
	
	
		try {
			PreparedStatement p = con.prepareStatement("select count(usuario) as total from login");
			ResultSet r = p.executeQuery();			
			 r.next();
			
			
			Integer qtdUsuario = r.getInt("total");
			qtdUsuarioTotal = new UsuarioLogin(qtdUsuario);
			qtdUsuarioTotal.setQtdUsuario(qtdUsuario);
		
				
			
			r.close();
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return qtdUsuarioTotal;
	}
	
	

	
	public UsuarioLogin conferencia(String nome, String usuario, String senha) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		
		UsuarioLogin user = null;
		try {
			PreparedStatement preStat = connection.prepareStatement("select * from login where usuario = ? ");
			preStat.setString(1, usuario);
			ResultSet resultSet = preStat.executeQuery();
			while(resultSet.next()) {
				String nome1 = resultSet.getString("nome");
				String usuario1 = resultSet.getString("usuario");
				String senha1 = resultSet.getString("senha");
				Integer id1 = resultSet.getInt("cod_usuario");
				if (usuario.equals(usuario1)) {
					user = new UsuarioLogin(nome1, usuario1, senha1);
					user.setCod_usuario(id1);
					return user;
				} else{
					System.out.println("usuario ou senha invalidos!");}
				}
			}catch (SQLException e) {

				e.printStackTrace();
			}
		return user;
		
		}
	
	
	public boolean conferenciaUsuario(UsuarioLogin user) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		
		boolean status = false;
		
		
	String sql = "select * from login where usuario = ? and senha = ?";
	//String sql = "select * from USER_ADM where  = ?  OR NOME =? AND SENHA =?";
		PreparedStatement ps;
		try {
		ps = connection.prepareStatement(sql);
		ps.setString(1, user.getUsuario());
		ps.setString(2, user.getSenha());
		//ps.setString(3, user.getNome());
		
		ResultSet rs = ps.executeQuery();
		status = rs.next();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
		}
	
	
//	public void logar(String usuario, String senha) {
//		Conexao conexao = Conexao.getInstance();
//		Connection connection = conexao.getConnection();
//		
//		try {
//		if (conexao != null) {
//            
//                PreparedStatement st = connection.prepareStatement("select * from login where usuario = ? and senha= ?");
//                st.setString(1, usuario);
//                st.setString(2, senha);
//                ResultSet resultSet = st.executeQuery();
//
//                resultSet.next();   
//            
//        }else {
//            System.out.println("Não é possivel logar");
//        }
//		}catch(SQLException e){
//			e.printStackTrace();
//		}
//	}

}
