package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormularioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}

	@SuppressWarnings("static-access")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		// Valores de prueba
		String usuarioCorrecto = "Juan";
		String passwordCorrecto = "1234";

		String pUsuario = req.getParameter("usuario");
		String pPssword = req.getParameter("password");

		if (usuarioCorrecto.equals(pUsuario)
				&& passwordCorrecto.equals(pPssword)) {
			out.print("Datos Validos ...");
		} else {
			// Respondemos al navegador con un codigo de No autorizado
			resp.sendError(resp.SC_UNAUTHORIZED,
					"Las credenciales son invalidas.");
		}
		out.close();

	}

}
