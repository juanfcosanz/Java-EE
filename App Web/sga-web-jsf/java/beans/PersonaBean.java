package beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaService;

import org.primefaces.event.RowEditEvent;

@ManagedBean
@RequestScoped
public class PersonaBean {

	@EJB
	private PersonaService personaService;
	

	private String nombre;
	private String apePaterno;
	private String apeMaterno;
	private String email;
	private String telefono;

	List<Persona> personas;
	
	private Persona selectedPersona;
	


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApePaterno() {
		return apePaterno;
	}

	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}

	public String getApeMaterno() {
		return apeMaterno;
	}

	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public PersonaBean() {
	}

	@PostConstruct
	public void inicializar() {
		personas = personaService.listarPersonas();
	}

	public void editListener(RowEditEvent event) {
		Persona persona = (Persona) event.getObject();
		personaService.modificarPersona(persona);

	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public void guardarPersona(ActionEvent actionEvent) {

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Persona " + nombre + " " + apePaterno));
		personaService.registrarPersona(new Persona(nombre,apePaterno,apeMaterno,email,telefono));
		
	}
	
	public Persona getSelectedPersona() {
		return selectedPersona;
	}

	public void setSelectedPersona(Persona selectedPersona) {
		this.selectedPersona = selectedPersona;
	}

	public void eliminarPersona(){
		personaService.eliminarPersona(selectedPersona);
	}
}