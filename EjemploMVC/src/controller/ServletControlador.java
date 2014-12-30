package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. En este caso no hay necesidad de procesar parametros
		
		//2. Creamos los JavaBeans
		Rectangulo rec = new Rectangulo(3,6);
		
		//3. Agregamos las variables en cierto alcance (scope)
		request.setAttribute("mensaje", "Saludos desde el Servlet");
		
		HttpSession session = request.getSession();
		session.setAttribute("rectangulo", rec);
		
		//4. Redireccionamos
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("vistas/desplegarVariables.jsp");
		//Se propagan los objetos request y response
		//para que puedan ser utilizados por el JSP seleccionado
		dispatcher.forward(request, response);
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
