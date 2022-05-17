<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" href="imgs/favicon.png"/>
<title>Pimpolhos ADM</title>

<link rel="stylesheet" href="style.css" type="text/css">
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	 <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="#">Meu perfil</a>
                        </li>
                        <hr>
                        <li class="nav-item">
                            <a class="nav-link clientes " aria-current="page" href="ServletPimpolhos">Clientes</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link categorias" href="ServletCategoria">Categorias</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link produtos" href="ServletProduto">Produtos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link fornecedores" href="ServletFornecedor">Fornecedores</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link pedidos" href="ServletPedido">Pedidos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link marcas" href="ServletMarca">Marcas</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
     
    </nav>

    <div class="row bodyRow" style="justify-content:space-around;">
        <div class="col-2 navLateral">
            <ul class="navbar-nav menuLateralTab">
              <li class="nav-item"><a class="nav-link" aria-current="page" href="#">Meu perfil</a>
            	<hr>
                <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="ServletPimpolhos">
                            	<div class="row">
                            		<img  class= "col-3" alt="" src="imgs/user (1).png" width="13%">
                      				<span class="col-6"> Cliente</span>
                     			</div>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="ServletCategoria">
                            	<div class="row">
                            		<img  class= "col-3" alt="" src="imgs/categories.png" width="13%">
                      				<span class="col-6"> Categorias</span>
                     			</div>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="ServletProduto">
                            	<div class="row">
                            		<img  class= "col-3" alt="" src="imgs/produto.png" width="13%">
                      				<span class="col-6"> Produtos</span>
                     			</div>
                            </a>
                        </li>
                        <li class="nav-item" >
                            <a class="nav-link" href="ServletFornecedor">
                            	<div class="row" >
                            		<img  class= "col-3" alt="" src="imgs/fornecedor.png" width="13%">
                      				<span class="col-6"> Fornecedores</span>
                     			</div>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="ServletPedido">
                            	<div class="row">
                            		<img  class= "col-3" alt="" src="imgs/pedido.png" width="13%">
                      				<span class="col-6"> Pedido</span>
                     			</div>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="ServletMarca">
                            	<div class="row">
                            		<img  class= "col-3" alt="" src="imgs/etiqueta.png" width="13%">
                      				<span class="col-6"> Marca</span>
                     			</div>
                            </a>
                </li>
            </ul>
        </div>
        
        
        
        
        <div class="col-9 conteudo">
            <form action="ServletPedido" method="post">

         <c:choose>
			<c:when test="${ pedido == null }">
			<div class="container mt-5 col-6" style="outline: 1px solid #d5d5d5; border-radius: 11px; padding: 16px;">
				<label style="margin-right: 17px;">Frete:</label><input type="text" name="cod_frete"/><br>
				<label style="margin-right: 23px;">Endereco:</label><input type="text" name="cod_endereco"/><br>
				<label style="margin-right: 32px;">Cliente:</label><input type="text" name="cod_cliente"/><br>
			    <label style="margin-right: 32px;">Status:</label><input type="text" name="cod_status"/><br>
			    <label style="margin-right: 32px;">Operação:</label><input type="text" name="cod_operacao"/><br>
			    <label style="margin-right: 32px;">Forma Pagamento:</label><input type="text" name="cod_forma_pagamento"/><br>
			    
			    
				<button class="btn btn-primary btnPage" type="submit" name="optionPedido" value="insertPedido">Salvar</button>
				</div>
			</c:when>
			<c:otherwise>
			<div class="container mt-5 col-6" style="outline: 1px solid #d5d5d5; border-radius: 11px; padding: 16px;">
				<input type="hidden" name="cod_pedido" value="${pedido.cod_pedido}"/><br>
				<label style="margin-right: 17px;">Frete:</label>
				<input type="text" name="cod_frete" value="${pedido.cod_frete}" required/><br>
				<label style="margin-right: 23px;">Endereco:</label>
				<input type="text" name="cod_endereco" value="${pedido.cod_endereco}" required/><br>
				<label style="margin-right: 23px;">Cliente:</label>
				<input type="text" name="cod_cliente" value="${pedido.cod_cliente}"/><br>
				<label style="margin-right: 32px;">Status:</label>
				<input type="text" name="cod_status" value="${pedido.cod_status}"/><br>
				<label style="margin-right: 32px;">Operação:</label>
				<input type="text" name="cod_operacao" value="${pedido.cod_operacao}"/><br>
				<label style="margin-right: 32px;">Forma Pagamento:</label>
				<input type="text" name="cod_forma_pagamento" value="${pedido.cod_forma_pagamento}"/><br>
			
				<button class="btn btn-primary btnPage" type="submit" name="optionPedido" value="updatePedido">Atualizar</button>
			</div>
			</c:otherwise>
		</c:choose>
            </form>
        </div>
</body>
</html>
