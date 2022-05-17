<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" href="imgs/favicon.png" />
<title>Clientes</title>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
	<input type="checkbox" id="nav-toggle">
    <div class="sidebar">
        <div class="sidebar-brand">
            <h2><span class="las "></span> <span>Pimpolhos</span></h2>
        </div>

        <div class="sidebar-menu">
            <ul>
               <li>
                    <a href="ServletQuantidade" >
                        <img src="imgs/home.png" class="icon"><span class="icon "> Home </span></a>
                </li>
                

                <li>
                    <a href="ServletPimpolhos
                    " class="active" >
                        <img src="imgs/user (1).png" class="icon"><span class="icon "> Clientes</span></a>
                </li>

 				<li>
                    <a href="ServletCategoria
                    ">
                        <img src="imgs/categories.png" class="icon"><span class="icon "> Categorias </span></a>
                </li>
                
                <li>
                    <a href="ServletPedido
                    ">
                        <img src="imgs/pedido.png" class="icon"><span class="icon "> Pedidos </span></a>
                </li>

                <li>
                    <a href="ServletFornecedor
                    ">
                        <img src="imgs/fornecedor.png" class="icon"><span class="icon "> Fornecedores </span></a>
                </li>
                <li>
                    <a href="ServletMarca
                    ">
                        <img src="imgs/etiqueta.png" class="icon"><span class="icon "> Marcas </span></a>
                </li>
                <li>
                    <a href="ServletProduto
                    ">
                        <img src="imgs/produto.png" class="icon"><span class="icon "> Produtos </span></a>
                </li>
            </ul>

        </div>
    </div>


    <div class="main-content">
        <div class="header-info">
            <h2>
                <label for="nav-toggle">
                    <span class="las "><img src="imgs/menu-aberto (1).png" ></span>
                </label>
                Painel de  Controle
            </h2>

		<% String usuario = (String) session.getAttribute("usuario");
		
			if(usuario == null){
				response.sendRedirect("index.jsp");
			}
		%>

            <div class="user-wrapper">
                <img src="imgs/carrinho.png" width="40px" height="40px" alt="">
                <div>
                    <h4>Pimpolhos</h4>
                    <form action="ServletMarca" method="post">
                    	<button type="submit" class="logout" name="optionMarca" value="sair">Sair</button>
                    </form>
                    
                    
	                    
                </div>
            </div>
        </div>


	



	


	<div class="tabela" >
		<div class="col-md-12 col-lg-9 conteudo ">
			<div class="table-responsive">
				<table class="table table-hover">
					<thead>
						<tr>
							<th scope="col">ID</th>
							 <th scope="col">Nome</th>
							 <th scope="col">CPF</th>
						     <th scope="col">Email</th>
							 <th scope="col">Ações</th>
					</thead>
					<tbody>
						<c:forEach var="usuario" items="${listUser}">
							<tr>

								<form action="ServletPimpolhos" method="post">
									<td data-label="ID"><c:out value="${usuario.cod_cliente}" /><input
										type="hidden" name="cod_cliente"
										value="${usuario.cod_cliente}" /></td>
									<td data-label="Nome Cliente"><c:out value="${usuario.nome}" /></td>
									<td data-label="CPF" class="cpf"><c:out value="${usuario.cpf}" /></span></td>
									<td data-label="Email"><c:out value="${usuario.email}" /></td>
									
									<td data-label="Ações">
										<button class="btn btn-primary btnPageReload" type="submit" name="option" value="cartaoSelecionado">Detalhes</button>
									</td>
								</form>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br>
				<a href="ServletPimpolhos?page=1">1</a>
				<a href="ServletPimpolhos?page=2">2</a>
				<a href="ServletPimpolhos?page=3">3</a>
			</div>
		</div>
	</div>
</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.11/jquery.mask.min.js"></script>
	<script src="app.js"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>