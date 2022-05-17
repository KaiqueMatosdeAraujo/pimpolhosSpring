<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" href="imgs/favicon.png" />
<title>Pedido</title>
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
                    <a href="ServletQuantidade
                    " >
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
                    " class="active">
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
                    <form action="ServletPedido" method="post">
                    	<button type="submit" class="logout" name="optionPedido" value="sair">Sair</button>
                    </form>
                    
                    
	                    
                </div>
            </div>
        </div>
        
 <div class="col-12 detalhesClienteAccordionBg" style="margin-top: 15%;">   
     <c:forEach var="pedido" items="${DetalhePedido}">  
		<form action="ServletPimpolhos" method="post">
		
			<div class="detalheClienteCabecalho  row rowGutter">
			<div class="col-12 maintitleDetails"> Pedido nº: <c:out value="${pedido.cod_pedido}"/></div>
			<div class="detalheClienteCabecalho rowCentralized">
			
			<div class="col-6">
			
			<div class= "col-11 pedidoInfo"> <span class="accordionInfoTitle">Id do Cliente:</span> <span class="accordionInfoText"> <c:out value="${pedido.cod_cliente}"/></span> </div>
			<div class= "col-11 pedidoInfo"> <span class="accordionInfoTitle">Endereço:</span> <span class="accordionInfoText"><c:out value="${pedido.nome_rua}"/></span> </div>
			<div class= "col-11 pedidoInfo"> <span class="accordionInfoTitle">Complemento:</span><span class="accordionInfoText"> <c:out value="${pedido.complemento}"/></span> </div>
			<div class= "col-11 pedidoInfo"> <span class="accordionInfoTitle">Bairro:</span><span class="accordionInfoText"> <c:out value="${pedido.bairro}"/></span> </div>
			<div class= "col-11 pedidoInfo"> <span class="accordionInfoTitle">Cidade:</span><span class="accordionInfoText"> <c:out value="${pedido.nome_cidade}"/></span> </div>
			<div class= "col-11 pedidoInfo"> <span class="accordionInfoTitle">Data do Pedido:</span><span class="accordionInfoText data">  <c:out value="${pedido.data_pedido}"/></span> </div>
			<div class= "col-11 pedidoInfo"> <span class="accordionInfoTitle">Forma de Pagamento:</span><span class="accordionInfoText"> <c:out value="${pedido.descricao_forma_pagamento}"/></span> </div>
			<div class= "col-11 pedidoInfo"> <span class="accordionInfoTitle">Quantidade de itens:</span><span class="accordionInfoText"> <c:out value="${pedido.quantidade}"/></span> </div>
			</div>
			
			<div class="col-5">
			
			<div class= "col-11 pedidoInfo"> <span class="accordionInfoTitle">Cliente:</span> <span class="accordionInfoText"> <c:out value="${pedido.nome_cliente}"/></span> </div>
			<div class= "col-11 pedidoInfo"> <span class="accordionInfoTitle">Nº:</span> <span class="accordionInfoText"><c:out value="${pedido.numero_casa}"/></span> </div>
			<div class= "col-11 pedidoInfo"> <span class="accordionInfoTitle">Ponto de Referencia:</span><span class="accordionInfoText"> <c:out value="${pedido.ponto_referencia}"/></span> </div>
			<div class= "col-11 pedidoInfo"> <span class="accordionInfoTitle">CEP:</span><span class="accordionInfoText"> <c:out value="${pedido.cep}"/></span> </div>
			<div class= "col-11 pedidoInfo"> <span class="accordionInfoTitle">UF:</span><span class="accordionInfoText"> <c:out value="${pedido.descricao_estado}"/></span> </div>
		    <div class= "col-11 pedidoInfo"> <span class="accordionInfoTitle">Status:</span><span class="accordionInfoText"> <c:out value="${pedido.descricao_status_pedido}"/></span> </div>
			<div class= "col-11 pedidoInfo"> <span class="accordionInfoTitle">Tipo de Frete:</span><span class="accordionInfoText"> <c:out value="${pedido.descricao_frete}"/></span> </div>
			<div class= "col-11 pedidoInfo"> <span class="accordionInfoTitle">Valor total:</span><span class="accordionInfoText"> <c:out value="${pedido.valor_total}"/></span> </div>
	     	</div>
	     	
	     	
	     	</div>
	     	</div>
	     	
		</form>
  </c:forEach>
    
    
<!-- ACCORDION -->
<div class="accordion" id="accordionExample">
	  			<div class="accordion-item">
				    <h2 class="accordion-header" id="heading-">
				      <button class="accordion-button custom-accordion" type="button" data-bs-toggle="collapse" data-bs-target="#collapseCard" aria-expanded="true" aria-controls="collapseCard">
				       	 Itens do Pedido
				      </button>
				    </h2>
	                    
			<input type="hidden" name="cod_pedido" value="${pedido.cod_produto}"/>
	                                                  
		      <div id="collapseCard" class="accordion-collapse collapse " aria-labelledby="headingCard data-bs-parent="#accordionExample">
		      <div class="accordion-body">
		      		<div>
				       <form action="ServletPedido" method="post">
		      		   <div class="row accordionContentSpace">
		      		<c:forEach var="pedido" items="${listaItemDetalhePedido}">
				<div class="col-11 col-lg-5  clientDetails">
				        <p><span class="accordionInfoTitle">Produto:</span> <span class="accordionInfoText"><c:out value="${pedido.nome}"/></span></p>
				        <p><span class="accordionInfoTitle">Preço unitario:</span> <span class="accordionInfoText preco4 "><c:out value="${pedido.preco}"/></span></p>
				        <p><span class="accordionInfoTitle">Marca:</span> <span class="accordionInfoText"><c:out value="${pedido.nome_marca}"/></span></p>
				        <p><span class="accordionInfoTitle">Quantidade:</span> <span class="accordionInfoText"><c:out value="${pedido.quantidade}"/></span></p>
				          <p><span class="accordionInfoTitle">Valor Total:</span> <span class="accordionInfoText"><c:out value="${pedido.valor_total}"/></span></p>
				        
				        </div>
	  	  </c:forEach>
	  	  </div>
	  	             </form>
</div>
</div>
</div>
</div>
</div>
  
    


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.11/jquery.mask.min.js"></script>
	<script src="app.js" ></script> 
</body>
</html>