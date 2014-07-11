package beans.alcances;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "peticion")
@RequestScoped
public class BeansAlcancePeticion {

	public BeansAlcancePeticion() {
	}

	private String valor;

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
