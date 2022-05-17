package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.DAOLoginCadastrar;
import model.DAOProduto;

/**
 * Servlet implementation class ServletQuantidade
 */
@WebServlet("/ServletQuantidade")
public class ServletQuantidade extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAO dao;
	private DAOProduto daoProduto;
	private DAOLoginCadastrar daoCadastro;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletQuantidade() {
        super();
       dao = new DAO();
       daoProduto = new DAOProduto();
       daoCadastro = new DAOLoginCadastrar();
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
//		String btn = request.getParameter("a");
//
//		if (btn == null) {
//			btn = "Op��o Invalida";
//	
//		}

		
		//if(btn.equals("atualizar")) {
			clientCount(request, response);
			pedidoCount(request, response);
			produtoCount(request, response);
			pedidoList(request, response);
			usuarioCount(request, response);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		//}
		
		
	}
	

	private void clientCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println(this.dao.qtdClienteTotal());
		request.setAttribute("quantidadeCliente", this.dao.qtdClienteTotal());
		//request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	private void pedidoCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println(this.dao.qtdPedidoTotal());
		request.setAttribute("quantidadePedido", this.dao.qtdPedidoTotal());
		//request.getRequestDispatcher("index.jsp").forward(request, response);

	}
	
	
	private void pedidoList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println(this.dao.exibirPedidosRecentes());
		request.setAttribute("listaPedidosRecentes", this.dao.exibirPedidosRecentes());
		//request.getRequestDispatcher("index.jsp").forward(request, response);

	}
	
	
	private void produtoCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println(this.daoProduto.qtdProdutoTotal());
		request.setAttribute("quantidadeProduto", this.daoProduto.qtdProdutoTotal());
		//request.getRequestDispatcher("index.jsp").forward(request, response);

	}
	
	
	private void usuarioCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println(this.daoCadastro.qtdUsuarioTotal());
		request.setAttribute("quantidadeUsuario", this.daoCadastro.qtdUsuarioTotal());
		//request.getRequestDispatcher("index.jsp").forward(request, response);

	}
	
}