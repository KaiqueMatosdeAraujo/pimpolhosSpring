<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Pimpolhos ADM</title>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
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
                    " class="active">
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

	<div class="container detalhesClienteAccordionBg" style="
    margin-top: 15%;">
    <c:forEach var="cliente" items="${detalhesPrincipal}">  
		<form action="ServletPimpolhos" method="post">
			<div class="detalheClienteCabecalho row">
			<div class="col-12 maintitleDetails">Informações Principais de  <c:out value="${cliente.nome}"/></div>
			<div class= "col-6 info-detalhe-cliente"> <span class="accordionInfoTitle">Id:</span> <span class="accordionInfoText"> <c:out value="${cliente.cod_cliente}"/></span> </div>
			<div class= "col-6 info-detalhe-cliente"> <span class="accordionInfoTitle">Cpf:</span> <span class="accordionInfoText cpf"><c:out value="${cliente.cpf}"/></span> </div>
			<div class= "col-6 info-detalhe-cliente"> <span class="accordionInfoTitle">Email:</span> <span class="accordionInfoText"><c:out value="${cliente.email}"/></span> </div>
			<div class= "col-6 info-detalhe-cliente"> <span class="accordionInfoTitle">Data de nascimento:</span><span class="accordionInfoText data"> <c:out  value="${cliente.nascimento}"/></span> </div>

		</form>
  </c:forEach>



</div>

<div class="accordion" id="accordionExample">
		<!-- INICIO ACCORDION ITEM ENDERECO -->
	  			<div class="accordion-item">
				    <h2 class="accordion-header" id="headingEndereco">
				      <button class="accordion-button custom-accordion" type="button" data-bs-toggle="collapse" data-bs-target="#collapseEndereco" aria-expanded="true" aria-controls="collapseEndereco">
				       	 Endereços
				      </button>
				    </h2>

			<input type="hidden" name="cod_cliente" value="${cliente.cod_cliente}"/>

		    <div id="collapseEndereco" class="accordion-collapse collapse " aria-labelledby="headingEndereco" data-bs-parent="#accordionExample">
		      <div class="accordion-body">

		      		<div>
		      		 <form action="ServletPimpolhos" method="post">
		      		   <div class="row accordionContentSpace">
		      		<c:forEach var="cliente" items="${listDetalhes}">  

		                <div class="col-11 col-lg-5  clientDetails">
				       <p><span class="accordionInfoTitle">Informações do Endereço</span></p>
				        <p><span class="accordionInfoTitle"> Rua:</span> <span class="accordionInfoText"><c:out value="${cliente.rua}"/></span></p>
				        <p><span class="accordionInfoTitle">Nº:</span> <span class="accordionInfoText"> <c:out value="${cliente.numeroCasa}"/></span></p>
				        <p><span class="accordionInfoTitle">Complemento:</span> <span class="accordionInfoText"><c:out value="${cliente.complemento}"/></span></p>
				        <p><span class="accordionInfoTitle">Ponto de Referencia:</span> <span class="accordionInfoText"><c:out value="${cliente.pontoReferencia}"/></span></p>
				        <p><span class="accordionInfoTitle">Cep:</span><span class="accordionInfoText cep"> <c:out value="${cliente.cep}"/></span></p>
				        <p><span class="accordionInfoTitle">Bairro:</span> <span class="accordionInfoText"><c:out value="${cliente.bairro}"/></span></p>
			            <p><span class="accordionInfoTitle">Cidade:</span> <span class="accordionInfoText"><c:out value="${cliente.cidade}"/></span></p>
			            <p><span class="accordionInfoTitle">Estado:</span><span class="accordionInfoText"> <c:out value="${cliente.estado}"/></span></p>
				        </div>

				          </c:forEach>
				           </div>
				         	</form>

			        </div>

		      </div>
		    </div>
	  	</div>
	  	<!-- FINAL ACCORDION ITEM ENDERECO -->


	  	<!-- INICIO ACCORDION ITEM Telefones -->
	  		<div class="accordion-item">
				    <h2 class="accordion-header" id="headingTelefone">
				      <button class="accordion-button custom-accordion" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTelefone" aria-expanded="true" aria-controls="collapseTelefone">
				       	 Telefones
				      </button>
				    </h2>

			<input type="hidden" name="cod_cliente" value="${cliente.cod_cliente}"/>

		    <div id="collapseTelefone" class="accordion-collapse collapse " aria-labelledby="headingTelefone" data-bs-parent="#accordionExample">
		      <div class="accordion-body">

		      		<div>
		      		 <form action="ServletPimpolhos" method="post">
		      		   <div class="row accordionContentSpace">
		      		<c:forEach var="cliente" items="${listaTelefone}">  

		                <div class="col-11 col-lg-5  clientDetails">
				        <p><span class="accordionInfoTitle">Informações do Telefone</span></p>
				        <p><span class="accordionInfoTitle">DDD:</span> <span class="accordionInfoText"><c:out value="${cliente.dddtelefone}"/></span></p>
				        <p><span class="accordionInfoTitle">Número:</span><span class="accordionInfoText celular"> <c:out value="${cliente.telefoneCliente}"/></span></p>
				        <p><span class="accordionInfoTitle">Tipo:</span> <span class="accordionInfoText"><c:out value="${cliente.tipoTelefone}"/></span></p>

				        </div>

				          </c:forEach>
				           </div>
				         	</form>

			        </div>

		      </div>
		    </div>
	  	</div>
	  	<!-- FINAL ACCORDION ITEM TELEFONE -->



	  	  	<!-- INICIO ACCORDION ITEM CARTÃO -->
	  		<div class="accordion-item">
				    <h2 class="accordion-header" id="headingCard">
				      <button class="accordion-button custom-accordion" type="button" data-bs-toggle="collapse" data-bs-target="#collapseCard" aria-expanded="true" aria-controls="collapseCard">
				       	 Cartões
				      </button>
				    </h2>

			<input type="hidden" name="cod_cliente" value="${cliente.cod_cliente}"/>

		    <div id="collapseCard" class="accordion-collapse collapse " aria-labelledby="headingCard data-bs-parent="#accordionExample">
		      <div class="accordion-body">
		      
		      		<div>
		      		 <form action="ServletPimpolhos" method="post">
		      		   <div class="row accordionContentSpace">
		      		<c:forEach var="cliente" items="${listaCartao}">  
                      
		                <div class="col-11 col-lg-5  clientDetails">
				        <p><span class="accordionInfoTitle">Dados Cartão</span></p>
				        <p><span class="accordionInfoTitle">Nome do Titular:</span> <span class="accordionInfoText"><c:out value="${cliente.titularCartao}"/></span></p>
				        <p><span class="accordionInfoTitle">Número cartão:</span> <span class="accordionInfoText cartao"><c:out value="${cliente.nCartao}"/></span></p>
				        <p><span class="accordionInfoTitle">Validade:</span> <span class="accordionInfoText dataCart"><c:out value="${cliente.val}"/></span></p>
				        <p><span class="accordionInfoTitle">Bandeira:</span> <span class="accordionInfoText"><c:out value="${cliente.bandeira}"/></span></p>
				        
				        </div>
				       
				          </c:forEach>
				           </div>
				         	</form>
			        </div>
		       
		      </div>
		    </div>
	  	</div>
	  	<!-- FINAL ACCORDION ITEM CARTAO -->
 
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