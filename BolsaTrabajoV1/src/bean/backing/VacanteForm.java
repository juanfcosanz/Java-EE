package bean.backing;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import bean.model.Candidato;

@ManagedBean
@RequestScoped
public class VacanteForm {

	public VacanteForm() {
	}

	@ManagedProperty(value = "#{candidato}")
	private Candidato candidato;

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public String enviar() {
		System.out.println("enviar() Nombre= " + this.candidato.getNombre());
		System.out
				.println("enviar() Apellido= " + this.candidato.getApellido());
		System.out.println("enviar() sueldoDeseado= "
				+ this.candidato.getSueldoDeseado());

		if (this.candidato.getNombre().equals("Juan")) {
			if (this.candidato.getApellido().equals("Perez")) {
				String msg = "Gracias, pero Juan Perez ya trabaja con nosotros.";
				FacesMessage facesMessage = new FacesMessage(
						FacesMessage.SEVERITY_ERROR, msg, msg);
				FacesContext facesContext = FacesContext.getCurrentInstance();
				String clienteId = null; // Este es un mensaje global
				facesContext.addMessage(clienteId, facesMessage);
				return "index";
			}
			return "exito";
		} else {
			return "fallo";
		}

	}
}
