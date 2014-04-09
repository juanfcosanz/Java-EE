package concursantes;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Audiencia {
	@Pointcut("execution (* concursantes.Concursante.ejecutar(..))")
	public void ejecutarShow(){}
	
	@Around("ejecutarShow()")
	public void monitorearShow(ProceedingJoinPoint joinPoint){
		
		try {
			System.out.println("El show está por comenzar, favor de tomar asiento...");
			System.out.println("Favor de apagar celulares...");
			//anotamos la hora de inicio
			long horaInicio = System.currentTimeMillis();
			//se llama al método de negocio (metodo objetivo)
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
