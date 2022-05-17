package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private String url = "jdbc:mysql://localhost:3306/pimpolhos";
	private String username = "mateus";
	private String password = "M.teus2512";
	private static Connection connection = null;
	private static Conexao instance = null;

	public Conexao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver carregado");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Driver n�o carregado: " + e.getMessage());
		}
	}

	public static Conexao getInstance() {
		if (instance == null) {
			instance = new Conexao();
			System.out.println("Criando instance");
		}
		System.out.println("Retornando instance");
		return instance;
	}

	public Connection getConnection() {
		try {
			if ((connection == null) || (connection.isClosed())) {
				connection = DriverManager.getConnection(this.url, this.username, this.password);
				System.out.println("Conex�o estabelecida");
				return connection;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Conex�o n�o estabelecida: " + e.getMessage());
		}

		return connection;
	}

	public Connection ConectaMySql(String banco) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				connection = DriverManager.getConnection(url, username, password);
			} catch (SQLException ex) {
				System.out.println("Caminho, senha ou usuarios incorrestos");
			}

		} catch (ClassNotFoundException ex) {
			System.out.printf("Driver n�o encontrado");
		}
		return connection;
	}

	public void finalize() {
		System.out.println("Destroy");
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}