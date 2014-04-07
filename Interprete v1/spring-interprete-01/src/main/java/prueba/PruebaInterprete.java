package prueba;

import beans.InterpreteEspanol;
import beans.Traductor;

public class PruebaInterprete {

	public static void main(String[] args) {
		
		Traductor traductor = new Traductor();   
		InterpreteEspanol interprete = new InterpreteEspanol();
		//el interprete se inyescta manualmente
		//y solamente puede recibir un interprete en Español
		//No in no un interprete en Ingles u otros idiomas
		traductor.setInterprete(interprete);
		traductor.setNombre("Carlos Esparza");
		traductor.hablar();
		
	}

}
