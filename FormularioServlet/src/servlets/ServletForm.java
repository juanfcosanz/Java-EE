package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletForm extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// Leemos los parametros del formulario , por default el formulario es
		// de tipo get

		String usuario = req.getParameter("usuario");
		String password = req.getParameter("password");
		System.out.println("Usuario: " + usuario);
		System.out.println("Password: " + password);

		PrintWriter out = resp.getWriter();
		try {

			out.println("El usuario logueado es: " + usuario);
			out.print("<br/>");
			out.println("contraseña de " + usuario + " es: " + password);

		} finally {
			out.close();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
