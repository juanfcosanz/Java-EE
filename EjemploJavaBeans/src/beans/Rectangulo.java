package beans;

public class Rectangulo {

	private int base;
	private int altura;

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	/**
	 * Agregamos un metodo que no mapea con niguna propiedad
	 * sino que es el resultado de un calculo
	 **/
	
	public int getArea(){
		return this.base * this.altura;
	}
}
