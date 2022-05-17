<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
    
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, maxinum-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/style.css" type="text/css">
        <link rel="icon" href="imgs/favicon.png" />
    <title>Pimpolhos</title>
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
                    <a href="ServletQuantidade
                    " class="active">
                        <img src="imgs/home.png" class="icon"><span class="icon "> Home </span></a>
                </li>
                

                <li>
                    <a href="ServletPimpolhos
                    " >
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

        <main>

	



            <div class="cards">
                <div class="card-single">
                    <div>
                        <h1 style="color:white"
                        >${quantidadeCliente}</h1>
                        <span>Clientes</span>
                    </div>
                    <div>
                        <span class="las"><img src="imgs/user (1).png" class="icon-card" width="40px" height="40px" alt=""></span>
                    </div>
                </div>



                <div class="card-single">
                    <div>
                        <h1 style="color:white"
                        >${quantidadePedido}</h1>
                        <span>Pedidos</span>
                    </div>
                    <div>
                        <span class="las "><img src="imgs/pedido.png" class="icon-card" width="40px" height="40px" alt=""></span>
                    </div>
                </div>


                <div class="card-single">
                    <div>
                        <h1 style="color:white"
                        >${quantidadeProduto}</h1>
                        <span>Produtos</span>
                    </div>
                    <div>
                        <span class="las"> <img src="imgs/produto.png" class="icon-card" width="40px" height="40px" alt=""></span>
                    </div>
                </div>


                <div class="card-single">
                    <div>
                        <h1 style="color:white"
                        >${quantidadeUsuario}</h1>
                        <span>Coladoradores</span>
                    </div>
                    <div>
                        <span class="las"><img src="imgs/trabalho-em-equipe.png" class="icon-card colab" width="40px" height="40px" alt=""></span>
                    </div>
                </div>
            </div>
	

            <div class="recent-grid">
                <div class="projects">

                    <div class="card">
                        <div class="card-header">
                            <h3> Pedidos Recentes</h3>
                            <a href="ServletPedido"><button> Ver todos <span class="las la-arrow-right"></span></button></a>
                        </div>


                        <div class="card-body">
                            <table  class="dd"width="100%">
                                <thead>
                                    <tr>
                                         <th scope="col">Pedido </td>
                                        <th scope="col">Status </td>
                                        <th scope="col">Pagamento </td>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:forEach var="pedidoRecente" items="${listaPedidosRecentes}">
	                                    <tr>
	                                    	<form action="ServletQuantidade" method="post">
		                                        <td data-label="Pedido"><c:out value="${pedidoRecente.cod_pedido}"/>
		                                        	<input type="hidden" name="cod_pedido" value="${pedidoRecente.cod_pedido}" />
		                                        </td>
		                                         <td data-label="Status"><c:out value="${pedidoRecente.descricao_forma_pagamento}"/></td>
		                                        <td data-label="Pagamento" >
		                                            <c:out value="${pedidoRecente.descricao_status_pedido}"/>
		                                        </td>
	                                    </tr>
	                                 </c:forEach>
								<tbody>
                            </table>
                        </div>
                    </div>
                </div>

                <div class="customers">
                    <div class="card">
                        <div class="card-header title-cadastro">
                            <h3>Time</h3>
                            <a href="indexCadastrar.jsp"><h6>Cadastre-se</h6></a>
                        </div>


                        <div class="card-body">
                            <div class="table-responsive">
                                <table width="100%">

                                    <div class="customer">
                                        <div class="info">
                                            <img src="imgs/kath.png" width="40px" height="40px" alt="">
                                            <div>
                                                <h4>Kathleen Fidelis</h4>
                                                <small>Dev</small>
                                            </div>
                                        </div>

                                        <div class="contact">
                                            
                                            <span class="las la-comment"></span>
                                           
                                        </div>
                                    </div>

                                    <div class="customer">
                                        <div class="info">
                                            <img src="imgs/isa.png" width="40px" height="40px" alt="">
                                            <div>
                                                <h4>Isabella Botasso</h4>
                                                <small>Dev</small>
                                            </div>
                                        </div>

                                        <div class="contact">
                                            
                                            <span class="las la-comment"></span>
                                            
                                        </div>
                                    </div>

                                    <div class="customer">
                                        <div class="info">
                                            <img src="imgs/kaique.png" width="40px" height="40px" alt="">
                                            <div>
                                                <h4>Kaique Araujo</h4>
                                                <small>Dev</small>
                                            </div>
                                        </div>

                                        <div class="contact">
                                            
                                            <span class="las la-comment"></span>
                                            
                                        </div>
                                    </div>

                                    <div class="customer">
                                        <div class="info">
                                            <img src="imgs/gabriel.png" width="40px" height="40px" alt="">
                                            <div>
                                                <h4>Gabriel Gonzaga</h4>
                                                <small>Dev</small>
                                            </div>
                                        </div>

                                        <div class="contact">
                                           
                                            <span class="las la-comment"></span>
                                            
                                        </div>
                                    </div>
                                    <div class="customer">
                                        <div class="info">
                                            <img src="imgs/mateus.png" width="40px" height="40px" alt="">
                                            <div>
                                                <h4>Mateus Reis</h4>
                                                <small>Dev</small>
                                            </div>
                                        </div>

                                        <div class="contact">
                                            
                                            <span class="las la-comment"></span>
                                          
                                        </div>
                                    </div>
                                </table>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </main>
    </div>

</body>

</html>