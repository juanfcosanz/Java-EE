package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Rectangulo;

/**
 * Servlet implementation class ServletControlador
 */
public class ServletControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletControlador() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Procesamos la peticion

		// 1. Procesamos los parametros
		String accion = request.getParameter("accion");

		// 2. Creamos los JavaBeans
		Rectangulo rcRequest = new Rectangulo(1, 2);
		Rectangulo rcSession = new Rectangulo(3, 4);
		Rectangulo rcApplication = new Rectangulo(5, 6);

		if ("agregarVariables".equals(accion)) {
			// 3. Compartimos las variables en alcance respectivo

			// alcance request
			request.setAttribute("rectanguloRequest", rcRequest);

			// alcance session
			HttpSession session = request.getSession();
			session.setAttribute("rectanguloSession", rcSession);

			// alcance application
			ServletContext application = this.getServletContext();
			application.setAttribute("rectanguloApplication", rcApplication);

			// Agregamos un mensaje
			request.setAttribute("mensaje", "Las variables fieron agregadas");

			// 4. Redireccionamos al Jsp de inicio
			request.getRequestDispatcher("index.jsp")
					.forward(request, response);

		} else if ("listarVariables".equals(accion)) {
			// unicamente redireccionamos , no agregamos variables
			// y se desplegaran las variables
			request.getRequestDispatcher("/WEB-INF/alcanceVariables.jsp")
					.forward(request, response);

		} else {
			// 4. Redireccionamos a la pagina de inicio
			// en caso de que no coincida la accion
			request.setAttribute("mensaje", "Accion no proporcionada");

			// Redireccionamos
			request.getRequestDispatcher("index.jsp")
					.forward(request, response);

		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
