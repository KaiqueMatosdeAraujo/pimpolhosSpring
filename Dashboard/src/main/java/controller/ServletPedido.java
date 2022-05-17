package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
/**
 * Servlet implementation class ServletPedido
 */
@WebServlet("/ServletPedido")
public class ServletPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPedido() {
        super();
        // TODO Auto-generated constructor stub
        this.dao = new DAO();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String optionPedido = request.getParameter("optionPedido");
		
		if (optionPedido == null) {
			optionPedido = "Op��o Invalida";
		}
		
		switch(optionPedido) {
		case ("detalhePedido"):
			selectAllDetalhePedido(request, response);
		break;
//		case ("updateFormPedido"):
//			showUpdatePedido(request, response);
//		break;
//		case ("updatePedido"):
//			updatePedido(request, response);
//		break;
//		case ("deletePedido"):
//			deletePedido(request, response);
//		break;
//		case ("insertPedido"):
//			insertPedido(request, response);
//		break;
		case ("sair"):
			sair(request, response);
		break;
		default:
			selectAllPedido(request, response);
		}

	}


	private void selectAllPedido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("listaPedido", this.dao.exibirPedido());
		request.getRequestDispatcher("indexPedido.jsp").forward(request, response);
	}
	
	

	private void selectAllDetalhePedido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer id = Integer.parseInt(request.getParameter("cod_pedido"));
		request.setAttribute("listaItemDetalhePedido", this.dao.recuperarItemPedido(id));
		request.setAttribute("DetalhePedido", this.dao.recuperarDetalhePedido(id));
		request.getRequestDispatcher("indexDetalhePedido.jsp").forward(request, response);
	}
	
	private void sair(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.sendRedirect("deslogar.jsp");
	}


}