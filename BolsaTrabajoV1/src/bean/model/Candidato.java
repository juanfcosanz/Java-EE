package bean.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Candidato {

	public Candidato() {

	}

	private String nombre = "Introduce Nombre";
	private String apellido = "Introduce Apellidos";
	private String sueldoDeseado = "Introduce el Sueldo";

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getSueldoDeseado() {
		return sueldoDeseado;
	}

	public void setSueldoDeseado(String sueldoDeseado) {

		System.out.println("Modificacion del modelo. Valor sueldo: "
				+ sueldoDeseado);
		this.sueldoDeseado = sueldoDeseado;
	}

}
