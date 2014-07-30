package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContadorVisitasServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Declaramos la variable contador
		int contador = 0;

		// Si existe la cookie, obtenemos el valor del contador de visitas
		// actual

		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("contadorVisitas")) {
					contador = Integer.parseInt(c.getValue());
				}
			}
		}

		// Incrementamos el contador de visitas y agrgamps la cookie en el
		// objeto response
		contador++;
		Cookie c = new Cookie("contadorVisitas", Integer.toString(contador));

		// almacenamos la cookie por 1 hora en el cliente, despues de ese tiempo
		// se elimina
		c.setMaxAge(3600); // 3600 seg
		resp.addCookie(c);

		// Manadamos la respuesta al navegador web(cliente)
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("Contador de visitas de cada cliente: " + contador);
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}

}
