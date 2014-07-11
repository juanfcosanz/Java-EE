package beans.alcances;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "aplicacion")
@ApplicationScoped
public class BeansAlcanceAplicacion implements Serializable {

	private static final long serialVersionUID = 1253754380522573199L;

	public BeansAlcanceAplicacion() {

	}

	private String valor;

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
