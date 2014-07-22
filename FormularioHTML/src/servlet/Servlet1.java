package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		try {
			String usuario = req.getParameter("usuario");
			String password = req.getParameter("password");
			// El elemento tecnologia puede varios valores a la vez, por eso lo
			// procesamos como un arreglo
			String[] tecnologias = req.getParameterValues("tecnologia");
			String genero = req.getParameter("genero");
			String ocupacion = req.getParameter("ocupacion");
			String musica = req.getParameter("musica");
			String comentario = req.getParameter("comentarios");

			out.println("<html>");
			out.println("<head>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Los parametros procesados son: </h1>");
			out.println("<table border='0'>");

			out.println("<tr>");
			out.println("<td>");
			out.println("Usuario: ");
			out.println("</td>");
			out.println("<td>");
			out.println(usuario);
			out.println("</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>");
			out.println("Password: ");
			out.println("</td>");
			out.println("<td>");
			out.println(password);
			out.println("</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>");
			out.println("Tecnologias: ");
			out.println("</td>");
			out.println("<td>");
			for (String tecnologia : tecnologias) {
				out.println(tecnologia);
				out.println(" ");
			}
			out.println("</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>");
			out.println("Genero: ");
			out.println("</td>");
			out.println("<td>");
			out.println(genero);
			out.println("</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>");
			out.println("Ocupacion: ");
			out.println("</td>");
			out.println("<td>");
			out.println(ocupacion);
			out.println("</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>");
			out.println("Musica: ");
			out.println("</td>");
			out.println("<td>");
			out.println(musica);
			out.println("</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>");
			out.println("Comentarios: ");
			out.println("</td>");
			out.println("<td>");
			out.println(comentario);
			out.println("</td>");
			out.println("</tr>");

			out.println("</table>");
			out.println("</body>");
			out.println("</html>");

		} finally {
			out.close();
		}

	}
}
