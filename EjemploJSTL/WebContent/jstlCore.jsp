
<!-- Con esta directiva importamos la libreria Core de JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL Core</title>
</head>
<body>
	<h1>JSTL Core</h1>

	<!-- Manipulacion de Variables -->
	<c:set var="nombre" value="Ernesto" />
	Variable nombre :
	<c:out value="${nombre}" />
	<br />
	<br /> Variable con codigo HTML:
	<c:out value="<h1>Hola</h1>" escapeXml="true" />
	<br />
	<br />
	<!-- Codigo condicional. uso de if -->
	<c:set var="bandera" value="true" />

	<c:if test="${bandera}">
	La bandera es verdadera
	</c:if>

	<br />
	<!-- Codigo condicional, uso de switch -->
	<c:if test="${param.opcion != null}">
		<c:choose>
			<c:when test="${param.opcion == 1}">
				<br />
				Ipcion 1 proporcionada
				<br />
			</c:when>
			<c:when test="${param.opcion == 2}">
				<br />
				Ipcion 2 proporcionada
				<br />
			</c:when>
			<c:otherwise>
				<br />
				Opcion proporcionada desconocida : ${param.opcion}
				<br />
			</c:otherwise>
		</c:choose>
	</c:if>

	<!-- Iteraccion de un arreglo -->
	<%
		//Creamos el arreglo con un scriptlet
		String[] nombres = { "Serch", "Leona", "Luis", "Kara" };
		//compartmos el arreglo de nonbres en el alcance(scope) se request
		request.setAttribute("nombres", nombres);
	%>
	<br /> Lista de Nombres:
	<br />
	<br />
	<ul>
		<c:forEach var="persona" items="${nombres}">
			<li>Nombre: ${persona}</li>
		</c:forEach>
	</ul>

	<br />
	<br />
	<a href="index.jsp">Regresar</a>


</body>
</html>