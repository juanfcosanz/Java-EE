package beans.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
// se va a contruir y destriur cada vz k se haga un peticion
@RequestScoped
public class Candidato {

	public Candidato() {
	}

	private String nombre = "Escribe tu nombre";

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
