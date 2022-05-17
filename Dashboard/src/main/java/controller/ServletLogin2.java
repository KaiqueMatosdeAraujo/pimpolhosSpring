package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAOLoginCadastrar;
import model.UsuarioLogin;

/**
 * Servlet implementation class ServletLogin2
 */
@WebServlet("/ServletLogin2")
public class ServletLogin2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	DAOLoginCadastrar dao = new DAOLoginCadastrar();
    UsuarioLogin usuarioLogin = new UsuarioLogin();
    int r;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nome = request.getParameter("nome");
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");


		
		usuarioLogin.setNome(nome);
		usuarioLogin.setUsuario(usuario);
		usuarioLogin.setSenha(senha);
		if (dao.conferenciaUsuario(usuarioLogin)){
			response.sendRedirect("ServletQuantidade");
			if(usuarioLogin != null) {
				HttpSession session = request.getSession(true);
				session.setAttribute("usuario", usuario);
			}
		}else {
			String message="Email ou Senha inválidos";
			request.setAttribute("message", message);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
	

}
