<%@ page import="utilerias.Conversiones, java.util.Date"%>
<%@ page import="utilerias.Conversiones"%>
<%@ page contentType="application/vnd.ms-excel"%>
<%
	String nombreArchivo = "reporte.xls";
	response.setHeader("Content-Disposition", "inline; filename "
			+ nombreArchivo);
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reporte Excel</title>
</head>
<body>
	<h1>Reporte de Excel</h1>
	<br />
	<table border="1">
		<tr>
			<th>Curso</th>
			<th>Descripci�n</th>
			<th>Fecha Inicio</th>
		</tr>
		<tr>
			<th>1. Fundamentos de Java</th>
			<th>Aprenderemos la sintaxis b�sica de java</th>
			<th><%=Conversiones.format(new Date())%></th>
		</tr>
		<tr>
			<th>2. Programacion con Java</th>
			<th>Pondramos en pr�ctiva conceptos de la Programaci�n</th>
			<th><%=Conversiones.format(new Date())%></th>
		</tr>
	</table>

</body>
</html>