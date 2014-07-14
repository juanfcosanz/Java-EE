package bean.backing;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import bean.helper.ColoniaHelper;
import bean.helper.FacesContextHelper;
import bean.model.Candidato;

@ManagedBean
@RequestScoped
public class VacanteForm {

	public VacanteForm() {
	}

	@ManagedProperty(value = "#{candidato}")
	private Candidato candidato;

	private boolean comentarioEnviado = false;

	@ManagedProperty(value = "#{coloniaHelper}")
	private ColoniaHelper coloniaHelper;

	public ColoniaHelper getColoniaHelper() {
		return coloniaHelper;
	}

	public void setColoniaHelper(ColoniaHelper coloniaHelper) {
		this.coloniaHelper = coloniaHelper;
	}

	public boolean isComentarioEnviado() {
		return comentarioEnviado;
	}

	public void setComentarioEnviado(boolean comentarioEnviado) {
		this.comentarioEnviado = comentarioEnviado;
	}

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
		System.out.println("enviar() Nacimiento: "
				+ this.candidato.getFechaNacimiento());

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

	public void codigoPostalListener(ValueChangeEvent valueChangeEvent){
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		UIViewRoot uiViewRoot = facesContext.getViewRoot();
		String newCodigoPostal = (String) valueChangeEvent.getNewValue();
		UIInput ciudadInputText = (UIInput) uiViewRoot.findComponent("vacanteForm:ciudad");
		String ciudad = "DF";
		ciudadInputText.setValue(ciudad);
		ciudadInputText.setSubmittedValue(ciudad);
		
		UIInput coloniaInputText = (UIInput) uiViewRoot.findComponent("vacanteForm:coloniaId");
		Long coloniaId = this.getColoniaHelper().getColoniaIdPorCP(Long.parseLong(newCodigoPostal));
		coloniaInputText.setValue(coloniaId);
		coloniaInputText.setSubmittedValue(coloniaId);
		
		facesContext.renderResponse();
	}

	public void ocultarComentario(ActionEvent actionEvent) {
		this.comentarioEnviado = !this.comentarioEnviado;
		FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesContextHelper.limpiarImmediateFacesMessages(facesContext);
	}

}
