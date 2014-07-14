package bean.model;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Candidato {

	public Candidato() {

	}

	private String nombre = "Introduce Nombre";
	private String apellido = "Introduce Apellidos";
	private int sueldoDeseado;
	private Date fechaNacimiento;
	private String ciudad;
	private String colonia;
	private String codigoPostal;
	private String comentario = "Escribe aquí tu comentario";

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

	public int getSueldoDeseado() {
		return sueldoDeseado;
	}

	public void setSueldoDeseado(int sueldoDeseado) {

		System.out.println("Modificacion del modelo. Valor sueldo: "
				+ sueldoDeseado);
		this.sueldoDeseado = sueldoDeseado;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

}
