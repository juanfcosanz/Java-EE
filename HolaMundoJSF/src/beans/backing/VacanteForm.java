package beans.backing;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import beans.model.Candidato;

@ManagedBean
@RequestScoped
public class VacanteForm {

	public VacanteForm() {
	}

	// inyectamos el valor del obj. de tipo candidato
	@ManagedProperty(value = "#{candidato}")
	private Candidato candidato;

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	// Metodo de flujo de control par aselccionar la pag. JSF a mostrar
	public String enviar() {
		// si el nombre intruducido es igual a Juan
		if (this.candidato.getNombre().equals("Juan")) {
			// redireccionamos el resultado hacia una pag. de nombre exito.xhtml
			return "exito";
		} else {
			// Cambiamos el flujo de navegacion, con solo especificar el nombre
			// de la pagina
			return "fallo"; // fallo.xhtml
		}
	}
}
