
$(document).ready(function(){
	$(".telefone, .celular").mask("0000-0000");
	$(".cpf").mask("000.000.000-00"); 
	$(".preco").mask("R$ 0.000,00", {reverse: false}); 
	$(".preco2").mask(" 000,00");
	$(".preco3").mask("R$ 00,00");
	$(".preco4").mask("R$ 000,00");
	$(".cep").mask("00000-000"); 
	$(".dimensao").mask("00x00 cm"); 
	$(".pesoForm").mask("0.000 kg"); 
	$(".peso2").mask("0.000");  
	$(".cnpj").mask("00.000.000/0000-00", {reverse: true});  
	$(".cartao").mask("**** **** **** 0000");
    $(".data").mask("00/00/0000");
	$(".dataCart").mask("00/00");

	 var $target = $("#mensagem");  	
	$target.keydown(function(event){
		console.log(event);
		console.log($target);
	if (event.target.value == " "   && event.keyCode == 32){
		$target.val("");
		
	}
	
	
	var dateMask = IMask(
  document.getElementById('date-mask'),
  {
    mask: Date,
    min: new Date(1990, 0, 1),
    max: new Date(2022, 0, 1),
    lazy: false
  });


	})
});