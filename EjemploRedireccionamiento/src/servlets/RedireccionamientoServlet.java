package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedireccionamientoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String url = null;
		String tipoNavegador = req.getHeader("User-Agent");

		if (tipoNavegador != null && tipoNavegador.contains("MSIE")) {
			url = "http://www.microsoft.com";
		} else if (tipoNavegador != null && tipoNavegador.contains("Firefox")) {
			url = "http://www.firefox.com";
		}

		// Redireccionamos a la url seleccionada
		resp.sendRedirect(url);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	}

}
