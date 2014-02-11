$(document).ready(function(){
	$('button').click(function(){
		
		var url = window.location.toString();
		var urlArray = url.split("/");
		 
		var novaUrl = "";
		for(var i = 0; i < urlArray.length - 1; i++) {
			novaUrl = novaUrl + urlArray[i] + '/';
		}
		
		jQuery.getJSON( novaUrl + "recuperacao_de_senha/recuperar" , { email: $('input[name="email"]').val() })
		.done(function(data){
			if(data == false) {
				alert("Erro no e-mail enviado");
			} else {
				alert("Seu e-mail foi enviado corretamente!");
			}
			
			
		}).fail(function(erro){
			alert("n�o foi poss�vel enviar a informa��o. Tente de novo");
		});
	});
});