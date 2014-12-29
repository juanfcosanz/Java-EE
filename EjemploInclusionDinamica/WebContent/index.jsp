<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ejemplo de Inclusion Dinamica</title>
</head>
<body>
	<h1>Inclusion Dinámica</h1>
	<jsp:include page="WEB-INF/recursoPrivado.jsp">
		<jsp:param value="yellow" name="colorFondo" />
	</jsp:include>
	<br />
	
	<jsp:include page="recursoPublico.jsp" />

</body>
</html>