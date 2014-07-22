package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletHeaders extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		try {
			// Procesamos los headers relacionados con la inf. de la peticion
			String metodoHttp = req.getMethod();
			String uri = req.getRequestURI();

			out.println("Headers HTTP");
			out.println("<br>");
			out.println("<br>");
			out.println("Metodo Http: " + metodoHttp);
			out.println("<br>");
			out.println("Uri solicitado: " + uri);
			out.println("<br>");
			out.println("<br>");

			// Procesamos algunos cabeceros que son parte de la peticion
			out.println("Host: " + req.getHeader("Host"));
			out.println("<br>");
			out.println("Navegador: " + req.getHeader("User-Agent"));

			// Procesamos todos los cabeceros, estos pueden varias segun el
			// navegador
			out.println("<br>");
			out.println("<br>");
			@SuppressWarnings("rawtypes")
			Enumeration cabeceros = req.getHeaderNames();
			while (cabeceros.hasMoreElements()) {
				String nombreCabecero = (String) cabeceros.nextElement();
				out.println(nombreCabecero + ": ");
				out.println(req.getHeader(nombreCabecero));
				out.println("<br>");
			}

		} finally {
			out.close();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
