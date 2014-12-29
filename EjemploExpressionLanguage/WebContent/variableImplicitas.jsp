<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Variables Implicitas</title>
</head>
<body>
	<h1>EL y Variables Implicitas</h1>
	<ul>
		<li>Nombre App: ${pageContext.request.contextPath }</li>
		<li>Navegador del cliente: ${header["user-agent"] }</li>
		<li>Id session: ${cookie.JSESSIONID.value }</li>
		<li>Web Server: ${pageContext.servletContext.serverInfo }</li>
		<li>Valor parametro usuario: ${param.usuario}</li>
	</ul>

</body>
</html>