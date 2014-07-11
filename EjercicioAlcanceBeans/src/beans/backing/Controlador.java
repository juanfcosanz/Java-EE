package beans.backing;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import beans.alcances.BeansAlcanceAplicacion;
import beans.alcances.BeansAlcancePeticion;
import beans.alcances.BeansAlcanceSession;
import beans.alcances.BeansAlcanceVista;

@ManagedBean
@RequestScoped
public class Controlador {

	public Controlador() {
	}

	@ManagedProperty(value = "#{peticion}")
	private BeansAlcancePeticion peticion;

	@ManagedProperty(value = "#{vista}")
	private BeansAlcanceVista vista;

	@ManagedProperty(value = "#{sesion}")
	private BeansAlcanceSession sesion;

	@ManagedProperty(value = "#{aplicacion}")
	private BeansAlcanceAplicacion aplicacion;

	public BeansAlcanceAplicacion getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(BeansAlcanceAplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

	public BeansAlcancePeticion getPeticion() {
		return peticion;
	}

	public void setPeticion(BeansAlcancePeticion peticion) {
		this.peticion = peticion;
	}

	public BeansAlcanceSession getSesion() {
		return sesion;
	}

	public void setSesion(BeansAlcanceSession sesion) {
		this.sesion = sesion;
	}

	public BeansAlcanceVista getVista() {
		return vista;
	}

	public void setVista(BeansAlcanceVista vista) {
		this.vista = vista;
	}

	// Metodo que controla los eventos, siempre y cuando no cambiemos de pagina
	public void cambiarValores(ActionEvent e) {
		System.out.println("Valores almacenados en cada ModelBean");

		System.out.println("Valor alcance request: " + peticion.getValor());
		System.out.println("Valor alcance Vista: " + vista.getValor());
		System.out.println("Valor alcance Sessión: " + sesion.getValor());
		System.out
				.println("Valor alcance Aplicación: " + aplicacion.getValor());

	}

	// Metodo (tipo Action) que visualiza que sucede cuando cambiamos de pagina
	public String cambiarPagina() {
		System.out.println("Cambio de Pagina");
		return "despliega"; // despliega.xhtml
	}

}
