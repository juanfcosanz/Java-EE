package concursantes;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class Audiencia {
	
	public void monitorearShow(ProceedingJoinPoint joinPoint){
		
		try {
			System.out.println("El show est� por comenzar, favor de tomar asiento...");
			System.out.println("Favor de apagar celulares...");
			//anotamos la hora de inicio
			long horaInicio = System.currentTimeMillis();
			//se llama al m�todo de negocio (metodo objetivo)
			joinPoint.proceed();
			Thread.sleep(1000);
			//1 segundo
			//este delay en milisegundos es opcional y se puede poner en los metodos
			//de negocio para simular la duracion del metodo
			long horaTermino = System.currentTimeMillis();
			System.out.println("El show ha terminado, aplausos");
			System.out.println("El show tubo una duracion: "+ (horaTermino-horaInicio));
		} catch (Throwable t) {
			System.out.println("El show fue terrible, se devolveran las entradas");
		}
		
	}
}
