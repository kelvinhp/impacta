<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>::Login</title>
</head>
<body>
	<h1>Login</h1>
		<form action=<c:url value="/validarUsuario"/> method="post">
		<label>Usu�rio:</label><br/>
		<input type="text" name="nome" size="20" /><br/>
		
		<label>Senha:</label><br/>
		<input type="password" name="senha" size="20" /><br/>
				
		<input type="submit" value="Validar">
	</form>
	${mensagem}
</body>
</html>