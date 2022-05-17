<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" href="imgs/favicon.png" />
<title>Fornecedor</title>

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
                    " class="active">
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
                    <form action="ServletFornecedor" method="post">
                    	<button type="submit" class="logout" name="optionFornecedor" value="sair">Sair</button>
                    </form>
                    
                    
	                    
                </div>
            </div>
        </div>
        



	  <div class="tabela">
	
    <form action="ServletFornecedor" method="post" >
		<button class="btn btn-primary btnPageReload"  href="ServletFornecedor"  name="optionFornecedor" value="insertFormFornecedor"> Adicionar Fornecedor</button>
    </form>
        <div class="col-md-12 col-lg-9 conteudo">
          
	            <table class="table table-hover ">
					<thead>
						<tr>
							<th scope="col">ID</th>
							 <th scope="col">Fornecedor</th>
							 <th scope="col">Ações</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="fornecedor" items="${listFornecedor}">
							<tr>
								<form action="ServletFornecedor" method="post" id="tabela">
									<td data-label="ID">
										<c:out value="${fornecedor.cod_fornecedor}"/>
										<input type="hidden" name="cod_fornecedor" value="${fornecedor.cod_fornecedor}"/>
									</td>
									<td data-label="Fornecedor"><c:out value="${fornecedor.nome_fornecedor}"/></td>
									
									<td data-label="Ações" class="btnAcoes">
									
										<button type="button" class="btn btn-primary btnPageReload" data-bs-toggle="modal" data-bs-target="#exampleModal-${fornecedor.cod_fornecedor}">Deletar</button>

									
									<div  class="modal fade" id="exampleModal-${fornecedor.cod_fornecedor}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
									  <div class="modal-dialog">
									    <div class="modal-content">
									      <div class="modal-header">
									        <h5 class="modal-title" >Deseja realmente deletar? </h5>
									        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
									      </div>
									      <div class="modal-body">
											 <c:out value="${fornecedor.nome_fornecedor}"/>     
									      </div>
									      <div class="modal-footer">
									        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
									        <button class="btn btn-primary btnPageReload" type="submit" name="optionFornecedor" value="deleteFornecedor">Deletar</button>
									      </div>
									    </div>
									  </div>
									</div>
										
										<button class="btn btn-primary btnPageReload" href="ServletFornecedor" name="optionFornecedor" value="updateFormFornecedor">Atualizar</button>
									</td>
								</form>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			
		</div>
	</div>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

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
		        toastr.success('Fornecedor excluido com sucesso!');
		    })
	     }
	</script>

</body>
</html>