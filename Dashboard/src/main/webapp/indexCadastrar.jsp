<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
 <%@page import="connection.ConexaoLogin"%>
 
<!DOCTYPE html>
<html>
<head>
	<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <link rel="stylesheet" href="./css/styleLogin1.css" type="text/css">
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" href="imgs/favicon.png" />
<title>Cadastro de Usuarios</title>
</head>
<body>
 <%
        ConexaoLogin conn = new ConexaoLogin();
                    Connection conexao = conn.ConectaMySql("login");
        %>
	       <div class="container-fluid">
	        <div class="col-12 display">
	            <div class=" row blocos col-xl-8">
	                <div class="bloco1 col-12 col-xl-5">
	                    <img src="imgs/Logo.png" alt="">
	                    <h3>Painel administrativo</h3>
	                </div>
	                <div class="bloco2 col-12 col-xl-7">
	                   <h2> <img src="imgs/userLogin.png" style="margin-right: 15px;"> Cadastro</h2><br>
	                    <p style="color: rgba(0, 0, 0, 0.63);">Faça seu cadastro:</p>
	                    <form class="col-11 col-xl-8 form-sign" action="ServletCadastroLogin" method="post" id="tabela">

	                        <div class="form-group">
                            <label>Nome Completo:</label>
                            <input type="text" name="nome" id="txtuser" value="" class="form-control">                              
                        </div>
                        <div class="form-group">
                            <label>Usuário:</label>
                            <input type="text" name="usuario" id="txtuser" value="" class="form-control">                              
                        </div>
                        <div class="form-group">
                            <label>Senha:</label>
                            <input type="password" name="senha" id="txtpass" value="" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Confirme Sua Senha:</label>
                            <input type="password" name="senha2" id="txtpass" value="" class="form-control">
                        </div>
							<p style="color:red;"> ${requestScope.message}</p>
	                        <button type="submit" name="optionLogin" value="insertUsuario" id="btnLog" class="btn btn-primary btn-block" ">Cadastrar</button>
	                        
	                    </form>
	                </div>
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
		        toastr.success('Usuario Cadastrado com Sucesso!');
		    })
	     }
	</script>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

</body>
</html> 