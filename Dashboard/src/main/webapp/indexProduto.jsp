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
<title>Produtos</title>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css"/>
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
                    <a href="ServletProduto" class="active">
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
        
<div class="tabela">
     <form action="ServletProduto" method="post">
		<button class="btn btn-secondary  btnPage btnPageReload" href="ServletProduto"  name="optionProduto" value="insertFormProduto"> Adicionar Produto</button>
	</form>
    
    <div class="accordion accordion-produto" id="accordionExample">
	<c:forEach var="produto" items="${listProduto}">  
		 <form action="ServletProduto" method="post" id="tabela">
	  			<div class="accordion-item">
				    <h2 class="accordion-header" id="heading-${produto.cod_produto}">
				      <button class="accordion-button custom-accordion" type="button" data-bs-toggle="collapse" data-bs-target="#collapse-${produto.cod_produto}" aria-expanded="true" aria-controls="collapse-${produto.cod_produto}">
				       	 Produto <c:out value="${produto.nome}"/>
				      </button>
				    </h2>
	                    
			<input type="hidden" name="cod_produto" value="${produto.cod_produto}"/>
	                                                  
		    <div id="collapse-${produto.cod_produto}" class="accordion-collapse collapse" aria-labelledby="heading-${produto.cod_produto}" data-bs-parent="#accordionExample">
		      <div class="accordion-body">
		      	<p style="text-transform: uppercase"><strong>Informações do produto</strong></p>
		      	
		      	<div style="display:flex;justify-content: space-between;">
		      		<div class="col-3">
				        
				        <p><strong>Código pedido:</strong> <c:out value="${produto.cod_produto}"/></p>
				        <p><strong>Nome:</strong> <c:out  value="${produto.nome}"/></p>
				        <p><strong>Preço:</strong><span class="preco4"> <c:out value="${produto.preco}"/></span></p>
				        <p><strong>Dimensão:</strong> <c:out value="${produto.dimensao}"/></p>
				        <p><strong>Material:</strong> <c:out value="${produto.material}"/></p>
				        <p><strong>Peso:</strong> <span class="pesoForm"><c:out value="${produto.peso}"/></span></p>
				        
				        
				     </div>
				     	
				     <div class="col-5">
				     	<p><strong>Conteúdo Produto:</strong><c:out value="${produto.conteudo_produto}"/></p>
				        <p><strong>Fornecedor:</strong> <c:out value="${produto.nome_fornecedor}"/></p>
				        <p><strong>Categoria:</strong> <c:out value="${produto.nome_categoria}"/></p>
				        <p><strong>Imagem:</strong> <c:out value="${produto.img_produto}"/></p>
				        <p><strong>Marca:</strong> <c:out value="${produto.nome_marca}"/></p>
				     </div> 
				         
		        </div>
		        
		        <div class="row btn-atualizar-deletar">
		         <!-- Button trigger modal -->
		         				<div class="col-4 col-md-3 btn-deletar">
									<button type="button" class="btn btn-primary btnPage" data-bs-toggle="modal" data-bs-target="#exampleModal-${produto.cod_produto}">Deletar</button>
								</div>
								
									<!-- Modal -->
									 <div  class="modal fade" id="exampleModal-${produto.cod_produto}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
									  <div class="modal-dialog">
									    <div class="modal-content">
									      <div class="modal-header">
									        <h5 class="modal-title" >Deseja realmente deletar? </h5>
									        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
									      </div>
									      <div class="modal-body">
											 <c:out value="${produto.nome}"/>     
									      </div>
									      <div class="modal-footer">
									        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
									        <button class="btn btn-primary btnPageReload" type="submit" name="optionProduto" value="deleteProduto">Deletar</button>
									      </div>
									    </div>
									  </div>
									</div>
                               		
                               		
                               	<div class="col-4  col-md-3 btn-atualizar">	
									<button href="ServletProduto" class="btn btn-primary btnPage" name="optionProduto" value="updateFormProduto">Atualizar</button>
								<div>	
					</div>
		      </div>
		    </div>
	  	</div>
	  	</div>
	  	</div>
  	</form>
  </c:forEach>
</div>
</div>
    
    
  
    </div>
    
    <!-- Begin: jQuery for Toast Message -->
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
 	<!-- End: jQuery for Toast Message -->
	<script type="text/javascript">
	
		let listSupplier = document.querySelectorAll('.tabela')
	   	let elements = Array.from(listSupplier)
	    console.log(elements)
	    
	     for (var i = 0; i < elements.length; i++) {
		    elements[i].addEventListener('submit', function(){
		        toastr.success('Produto excluido com sucesso!');
		    })
	     }
	</script>
    
   
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.11/jquery.mask.min.js"></script>
	<script src="app.js"></script>
</body>
</html>