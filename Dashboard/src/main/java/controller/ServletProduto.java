package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAOCategoria;
import model.DAOFornecedor;
import model.DAOMarca;
import model.DAOProduto;
import model.Produto;


@WebServlet("/ServletProduto")
public class ServletProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private DAOProduto daoproduto;
      private DAOCategoria daocategoria;
      private DAOFornecedor daofornecedor;
      private DAOMarca      daomarca;
      
      
   /**
    * @see HttpServlet#HttpServlet()
    */
   public ServletProduto() {
       super();
       // TODO Auto-generated constructor stub
       this.daoproduto = new DAOProduto();
       this.daofornecedor = new DAOFornecedor();
       this.daomarca = new DAOMarca();
       this.daocategoria = new DAOCategoria();
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
		
		
		
		String optionProduto = request.getParameter("optionProduto");
		if (optionProduto == null) {
			optionProduto = "Op��o Invalida";
		}
		switch(optionProduto) {
			case ("insertFormProduto"):
				showInsertProduto(request, response);
			break;
			case ("updateFormProduto"):
				showUpdateProduto(request, response);
			break;
			case ("updateProduto"):
				updateProduto(request, response);
			break;
			case ("deleteProduto"):
				deleteProduto(request, response);
			break;
			case ("insertProduto"):
				insertProduto(request, response);
			break;
			case ("sair"):
				sair(request, response);
			break;
			default:
				selectAllProdutos(request, response);
		}
		
	}

	
	
	private void showInsertProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("listCategoria",daocategoria.exibirCategoria());
		request.setAttribute("listFornecedor", daofornecedor.exibirFornecedor());
	    request.setAttribute("listMarca", daomarca.exibirMarca());
		request.getRequestDispatcher("formProduto.jsp").forward(request, response);
	}
	
	private void showUpdateProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("listCategoria",daocategoria.exibirCategoria());
		request.setAttribute("listMarca", daomarca.exibirMarca());
		request.setAttribute("listFornecedor", daofornecedor.exibirFornecedor());
		Integer id = Integer.parseInt(request.getParameter("cod_produto"));
		System.out.println(id);
		Produto produto = this.daoproduto.recuperarProduto(id);
		request.setAttribute("produto", produto);
		request.getRequestDispatcher("formProduto.jsp").forward(request, response);
	}
	
	
	
	private void insertProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String nomeBack = request.getParameter("nome").trim();
		String precoBack = request.getParameter("preco").trim();
		String dimensaoBack = request.getParameter("dimensao").trim();
		String materialBack = request.getParameter("material").trim();
		String pesoBack = request.getParameter("peso").trim();
		String conteudoBack = request.getParameter("conteudo").trim();
		Integer cod_fornecedorBack = Integer.parseInt(request.getParameter("cod_fornecedor").trim());
		Integer cod_categoriaBack = Integer.parseInt(request.getParameter("cod_categoria").trim());
		String img_produtoBack = request.getParameter("img_produto").trim();
		Integer cod_marcaBack = Integer.parseInt(request.getParameter("cod_marca").trim());
		
		Integer qtdEstoqueBack = Integer.parseInt(request.getParameter("qtd_estoque").trim());
		
		if ((nomeBack != null) && (precoBack != null) && (dimensaoBack != null) && (materialBack != null) && (pesoBack != null) && (conteudoBack != null) && (cod_fornecedorBack != null) && (cod_categoriaBack != null) && (img_produtoBack != null) && (cod_marcaBack != null) && (qtdEstoqueBack != null)) {
			if (!nomeBack.equals("")){
				Double preco2 = Double.parseDouble(precoBack.replace(",", "."));
				Double peso2 = Double.parseDouble(pesoBack.replace(",", "."));
				Produto produto = new Produto (nomeBack, preco2, dimensaoBack, materialBack, peso2, conteudoBack, cod_fornecedorBack, cod_categoriaBack, img_produtoBack, cod_marcaBack, qtdEstoqueBack);
				this.daoproduto.inserirProduto(produto);
	 }
		}
		try {
			Thread.sleep(2000);
		}
		catch(InterruptedException ex){
			ex.printStackTrace();


		}
		response.sendRedirect("ServletProduto");
	}
	
	private void selectAllProdutos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		request.setAttribute("listProduto", this.daoproduto.exibirProduto());
		request.getRequestDispatcher("indexProduto.jsp").forward(request, response);
	}
	
	private void deleteProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idBack = request.getParameter("cod_produto");
		if (idBack != null) {
			Integer id = Integer.parseInt(idBack);
			this.daoproduto.deletarProduto(id);
		}
		try {
			Thread.sleep(2000);
		}
		catch(InterruptedException ex){
			ex.printStackTrace();

		}
		response.sendRedirect("ServletProduto");
	}
	
	
	private void updateProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer cod_produtoBack = Integer.parseInt(request.getParameter("cod_produto"));
		String nomeBack = request.getParameter("nome");
		String precoBack = request.getParameter("preco");
		String dimensaoBack = request.getParameter("dimensao");
		String materialBack = request.getParameter("material");
		String pesoBack = request.getParameter("peso");
		String conteudoBack = request.getParameter("conteudo");
		Integer fornecedorBack = Integer.parseInt(request.getParameter("cod_fornecedor"));
		Integer categoriaBack = Integer.parseInt(request.getParameter("cod_categoria"));
		String img_produtoBack = request.getParameter("img_produto");
		Integer cod_marcaBack = Integer.parseInt(request.getParameter("cod_marca"));
		
		Integer qtdEstoqueBack = Integer.parseInt(request.getParameter("qtd_estoque"));
		
		if ((nomeBack != null) && (precoBack != null) && (dimensaoBack != null)
		&& (materialBack != null) && (pesoBack != null) && (conteudoBack != null) && (fornecedorBack != null) && (categoriaBack != null) && (img_produtoBack != null) && (cod_marcaBack != null) && (qtdEstoqueBack != null)) {
			if (!nomeBack.equals("")){
				
				Double preco2 = Double.parseDouble(precoBack.replace(",", "."));
				Double peso2 = Double.parseDouble(pesoBack.replace(",", "."));
				Integer id = (cod_produtoBack);
				Produto produto = new Produto (nomeBack, preco2, dimensaoBack, materialBack, peso2, conteudoBack, fornecedorBack, categoriaBack, img_produtoBack, cod_marcaBack, qtdEstoqueBack);
				produto.setCod_produto(id);
				this.daoproduto.atualizarProduto(produto);
			}
			try {
				Thread.sleep(2000);
			}
			catch(InterruptedException ex){
				ex.printStackTrace();


			}
		}
		response.sendRedirect("ServletProduto");
	}
	
	private void sair(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.sendRedirect("deslogar.jsp");
	}
}