package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.DAOMarca;
import model.Marca;


@WebServlet("/ServletMarca")
public class ServletMarca extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DAOMarca dao;
    public ServletMarca() {
        super();
        this.dao = new DAOMarca();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		

		
		String optionMarca = request.getParameter("optionMarca");
		if (optionMarca == null) {
			optionMarca = "Op��o Invalida";
		}
		switch(optionMarca) {
			case ("insertFormMarca"):
				showInsertMarca(request, response);
			break;
			case ("updateFormMarca"):
				showUpdateMarca(request, response);
			break;
			case ("updateMarca"):
				updateMarca(request, response);
			break;
			case ("deleteMarca"):
				deleteMarca(request, response);
			break;
			case ("insertMarca"):
				insertMarca(request, response);
			break;
			case ("sair"):
				sair(request, response);
			break;
			default:
				selectAllMarca(request, response);
		}
		
	}

	
	
	private void showInsertMarca(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("formMarca.jsp").forward(request, response);
	}
	
	private void showUpdateMarca(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer id = Integer.parseInt(request.getParameter("cod_marca"));
		Marca marca = this.dao.recuperarMarca(id);
		request.setAttribute("marca", marca);
		request.getRequestDispatcher("formMarca.jsp").forward(request, response);
	}
	
	private void insertMarca(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String nomeBack = request.getParameter("name").trim();
		
		
		if (nomeBack != null) {
			if (!nomeBack.equals("")){
				Marca user1 = new Marca (nomeBack);
				this.dao.inserirMarca(user1);
			}
		}
		try {
			Thread.sleep(2000);
		}
		catch(InterruptedException ex){
			ex.printStackTrace();
		}
		response.sendRedirect("ServletMarca");
	}
	
	private void selectAllMarca(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		request.setAttribute("listMarca", this.dao.exibirMarca());
		request.getRequestDispatcher("indexMarca.jsp").forward(request, response);
	}
	
	private void deleteMarca(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idBack = request.getParameter("cod_marca");

			if (idBack != null) {
				Integer id = Integer.parseInt(idBack);
				this.dao.deletarMarca(id);
			}
			try {
				Thread.sleep(2000);
			}
			catch(InterruptedException ex){
				ex.printStackTrace();


			}
			
		response.sendRedirect("ServletMarca");
	}
	
	private void updateMarca(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idBack = request.getParameter("cod_marca");
		String nomeBack = request.getParameter("name");
		
		if ((nomeBack != null) && (idBack != null)) {
			if (!nomeBack.equals("")){
				Integer id = Integer.parseInt(idBack);
				Marca marca = new Marca (nomeBack);
				marca.setCod_marca(id);
				this.dao.atualizarMarca(marca);
			}
			}
		try {
			Thread.sleep(2000);
		}
		catch(InterruptedException ex){
			ex.printStackTrace();
		}
		response.sendRedirect("ServletMarca");
	}
	
	private void sair(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.sendRedirect("deslogar.jsp");
	}
	
}
