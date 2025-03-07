<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Produtos</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="css/estilos.css" rel="stylesheet">
<link href="css/menu.css" rel="stylesheet">
<link href="css/produtos.css" rel="stylesheet">

</head>
<body>
	<header>
		<nav>
			<ul class="menu" id="menuTopo">
				<li><a href="index.jsp"><span class="glyphicon glyphicon-gift"></span></a></li>
				<li><a href="cadastro.jsp">Cadastro de Produtos</a></li>
				<li><a href="consulta.jsp">Buscar</a></li>
			</ul>
		</nav>
	</header>

	<section>
		<h1 style="text-align: center;">Cadastro de Produtos</h1>
		<form style="padding: 5%" action="produtos" method="post">
			<div class="form-group">
				<label for="codigo">C�digo</label> <input type="number"
					class="form-control" name="codigo" id="codigo">
			</div>
			<div class="form-group">
				<label for="descricao">Descri��o:</label> <input type="text"
					class="form-control" name="descricao" id="descricao">
			</div>
	
			<div class="form-group">
				<label for="preco">Pre�o</label> <input type="number"
					class="form-control" name="preco" id="preco">
			</div>
			
			<div class="form-group">
				<label for="fabricante">Fabricante:</label> <input type="text"
					class="form-control" name="fabricante" id="fabricante">
			</div>
			
			<div>
				<button type="submit" class="btn btn-default">Enviar</button>
			</div>
			<br/>
			<div class="alert alert-success" role="alert">${mensagem}</div>
		</form>
	</section>

	<footer class="footer">
		<p>Desenvolvido para os estagi�rios da Senior Solution</p>
		<p>Copyright 2017 - Todos os direitos reservados</p>
	</footer>
</body>
</html>