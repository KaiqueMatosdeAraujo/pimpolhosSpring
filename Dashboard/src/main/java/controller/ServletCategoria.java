package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Categoria;
import model.DAOCategoria;


/**
 * Servlet implementation class ServletCategoria
 */
@WebServlet("/ServletCategoria")
public class ServletCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private DAOCategoria dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCategoria() {
        super();
        // TODO Auto-generated constructor stub
        this.dao = new DAOCategoria();
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
		// TODO Auto-generated method stub
		
		
		
		String optionCategoria = request.getParameter("optionCategoria");
		if (optionCategoria == null) {
			optionCategoria = "Op��o Invalida";
		}
		switch(optionCategoria) {
			case ("insertFormCategoria"):
				showInsertCategoria(request, response);
			break;
			case ("updateFormCategoria"):
				showUpdateCategoria(request, response);
			break;
			case ("updateCategoria"):
				updateCategoria(request, response);
			break;
			case ("deleteCategoria"):
				deleteCategoria(request, response);
			break;
			case ("insertCategoria"):
				inserirCategoria(request, response);
			break;
			case ("sair"):
				sair(request, response);
			break;
			default:
				selectAllCategoria(request, response);
		}
		
	}

	
	
	private void showInsertCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("formCategoria.jsp").forward(request, response);
	}
	
	private void showUpdateCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer id = Integer.parseInt(request.getParameter("cod_categoria"));
		Categoria categoria = this.dao.recuperarCategoria(id);
		request.setAttribute("categoria", categoria);
		request.getRequestDispatcher("formCategoria.jsp").forward(request, response);
		
//		Integer id = Integer.parseInt(request.getParameter("id"));
//		User u = this.cont.selectById(id);
//		request.setAttribute("user", u);
//		request.getRequestDispatcher("form.jsp").forward(request, response);
	}
	
	private void inserirCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String nomeCategoriaBack = request.getParameter("name").trim();
		
		
		if ( nomeCategoriaBack != null) {
			if (!nomeCategoriaBack.equals("")){
				Categoria categoria1 = new Categoria (nomeCategoriaBack);
				this.dao.inserirCategoria(categoria1);
	}
			
		}
		try {
			Thread.sleep(2000);
		}
		catch(InterruptedException ex){
			ex.printStackTrace();


	
		}
		response.sendRedirect("ServletCategoria");
	}
	
	private void selectAllCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		request.setAttribute("listCategoria", this.dao.exibirCategoria());
		request.getRequestDispatcher("indexCategoria.jsp").forward(request, response);
	}
	
	private void deleteCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idBack = request.getParameter("cod_categoria");
		if (idBack != null) {
			Integer id = Integer.parseInt(idBack);
			this.dao.deletarCategoria(id);
		}
		try {
			Thread.sleep(2000);
		}
		catch(InterruptedException ex){
			ex.printStackTrace();
		}
		response.sendRedirect("ServletCategoria");
	}
	
	private void updateCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idBack = request.getParameter("cod_categoria");
		String nomeCategoriaBack = request.getParameter("name");
		
		
		if ((nomeCategoriaBack != null)) {
			if (!nomeCategoriaBack.equals("")){
				Integer id = Integer.parseInt(idBack);
				Categoria categoria = new Categoria (nomeCategoriaBack );
				categoria.setCod_categoria(id);
				this.dao.atualizarCategoria(categoria);
			}
		}
		try {
			Thread.sleep(2000);
		}
		catch(InterruptedException ex){
			ex.printStackTrace();


		}
	
		response.sendRedirect("ServletCategoria");
	}
	
	private void sair(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.sendRedirect("deslogar.jsp");
	}
	
	
}

