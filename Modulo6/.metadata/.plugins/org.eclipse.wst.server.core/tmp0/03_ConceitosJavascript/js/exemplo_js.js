var botao = document.getElementById("botao")

botao.addEventListener("click", function(){
	var nome = document.getElementById("nome").value;
	var idade = document.getElementById("idade").value;

	var mensagem = "Nome: " + nome + ", Idade: " + idade;

	//alert(mensagem);
	document.getElementById("resultado").innerHTML = mensagem;
});

