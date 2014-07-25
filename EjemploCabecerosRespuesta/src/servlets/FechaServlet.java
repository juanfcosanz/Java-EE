package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FechaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		// Enviamos el chache

		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("Cache-Control", "no-store");
		resp.setDateHeader("Expires", -1);

		// usamos el header para refrescar la pagina cada 1 segundo
		resp.setHeader("refresh", "1");

		// Obtenemos la fecha actual y damos un formato
		Date fecha = new Date();
		SimpleDateFormat formateador = new SimpleDateFormat(
				"dd 'de' MMM 'de' yyyy 'a las' HH:mm:ss");
		String fechaConFormato = formateador.format(fecha);

		out.println("Fecha Actualizada: " + fechaConFormato);

		out.close();

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}

}
