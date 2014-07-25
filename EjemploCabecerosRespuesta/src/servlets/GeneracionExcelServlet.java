package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GeneracionExcelServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// Especificamos el tipo del docuemnto de la repuesta (MIME)
		resp.setContentType("application/vnd.ms-excel");

		PrintWriter out = resp.getWriter();
		try {
			// Agregamos contenido al docuemnto de excel
			
			out.println("\tValores");
			out.println("\t5");
			out.println("\t2");
			out.println("Total\t=SUMA(B2:B3)");
		} finally {
			out.close();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	}

}
