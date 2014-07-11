package beans.alcances;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "sesion")
@SessionScoped
public class BeansAlcanceSession implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7497464196855641212L;

	public BeansAlcanceSession() {

	}

	private String valor;

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
