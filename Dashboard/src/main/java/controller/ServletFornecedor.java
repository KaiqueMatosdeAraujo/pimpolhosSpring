package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import model.DAOFornecedor;
import model.Fornecedor;


/**
 * Servlet implementation class ServletPimpolhos
 */
@WebServlet("/ServletFornecedor")
public class ServletFornecedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private DAOFornecedor dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFornecedor() {
        super();
        // TODO Auto-generated constructor stub
        this.dao = new DAOFornecedor();
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
		
		
		
		String optionFornecedor = request.getParameter("optionFornecedor");
		if (optionFornecedor == null) {
			optionFornecedor = "Op��o Invalida";
		}
		switch(optionFornecedor) {
			case ("insertFormFornecedor"):
				showInsertFornecedor(request, response);
			break;
			case ("updateFormFornecedor"):
				showUpdateFornecedor(request, response);
			break;
			case ("updateFornecedor"):
				updateFornecedor(request, response);
			break;
			case ("deleteFornecedor"):
				deleteFornecedor(request, response);
			break;
			case ("insertFornecedor"):
				inserirFornecedor(request, response);
			break;
			case ("sair"):
				sair(request, response);
			break;
			default:
				selectAllFornecedores(request, response);
		}
		
	}

	
	
	private void showInsertFornecedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("formFornecedor.jsp").forward(request, response);
	}
	
	private void showUpdateFornecedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer id = Integer.parseInt(request.getParameter("cod_fornecedor"));
		Fornecedor fornecedor = this.dao.recuperarFornecedor(id);
		request.setAttribute("fornecedor", fornecedor);
		request.getRequestDispatcher("formFornecedor.jsp").forward(request, response);
		
	}
	
	private void inserirFornecedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String nomeFornecedorBack = request.getParameter("name").trim();
		
		
		if ( nomeFornecedorBack != null) {
			if (!nomeFornecedorBack.equals("")){
				Fornecedor fornecedor1 = new Fornecedor (nomeFornecedorBack);
				this.dao.inserirFornecedor(fornecedor1);
	}
		}
		try {
			Thread.sleep(2000);
		}
		catch(InterruptedException ex){
			ex.printStackTrace();
		}

		
		response.sendRedirect("ServletFornecedor");
	}
	
	private void selectAllFornecedores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		request.setAttribute("listFornecedor", this.dao.exibirFornecedor());
		request.getRequestDispatcher("indexFornecedor.jsp").forward(request, response);
	}
	
	private void deleteFornecedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idBack = request.getParameter("cod_fornecedor");
		if (idBack != null) {
			Integer id = Integer.parseInt(idBack);
			this.dao.deletarFornecedor(id);
		}
		try {
			Thread.sleep(2000);
		}
		catch(InterruptedException ex){
			ex.printStackTrace();
		}
		response.sendRedirect("ServletFornecedor");
	}
	
	private void updateFornecedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idBack = request.getParameter("cod_fornecedor");
		String nomefornecedorBack = request.getParameter("name");
		
		
		if ((nomefornecedorBack != null)) {
			if (!nomefornecedorBack.equals("")){
				Integer id = Integer.parseInt(idBack);
				Fornecedor fornecedor = new Fornecedor (nomefornecedorBack );
				fornecedor.setCod_forcenedor(id);
				this.dao.atualizarFornecedor(fornecedor);
			}
		}
		try {
			Thread.sleep(2000);
		}
		catch(InterruptedException ex){
			ex.printStackTrace();


		}
		response.sendRedirect("ServletFornecedor");
	}
	
	private void sair(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.sendRedirect("deslogar.jsp");
	}
	
}
