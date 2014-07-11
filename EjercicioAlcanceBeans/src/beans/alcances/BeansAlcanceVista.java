package beans.alcances;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "vista")
@ViewScoped
public class BeansAlcanceVista implements Serializable {

	private static final long serialVersionUID = 8265013922101239953L;

	public BeansAlcanceVista() {
	}

	private String valor;

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
