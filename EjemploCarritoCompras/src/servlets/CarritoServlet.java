package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CarritoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Procesamos en nuevo articulo
		String nuevoArticulo = req.getParameter("articulo");

		// Creamos p recuperamos la sesion http
		HttpSession session = req.getSession();

		// Recuperamos la lista de articulos previos, si es qu existen en la
		// session
		@SuppressWarnings("unchecked")
		List<String> articulos = (List<String>) session.getAttribute("articulos");

		// Verificamos si la lista de articulos existe
		if (articulos == null) {
			// Si no existen, inicializamos la lista y la agregamos a la sesion
			articulos = new ArrayList<String>();
			session.setAttribute("articulos", articulos);
		}

		// Ya tenemos la lista de articulos, lista para trabajar, agregamos el
		// nuevo articulo, y lo agraganos por paso por referencia a la lista de
		// articulos
		if (nuevoArticulo != null && !nuevoArticulo.trim().equals("")) {
			articulos.add(nuevoArticulo);
		}

		// Mostramos los articulos totales al cliente
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<h1>Lista de Articulos</h1>");
		out.println("<br>");
		// iteramos los articulos, incluyendo el nuevo
		for (String articulo : articulos) {
			out.println("<Li>" + articulo + "</Li>");
		}
		out.println("<br>");
		out.println("<a href='/EjemploCarritoCompras/index.jsp'>Regresar</a>");
		out.close();
	}
}
