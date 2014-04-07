package prueba;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.BeanSpring;

public class PruebaSpring {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext contexto = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		
		BeanFactory fabrica = contexto;
		BeanSpring miBean = (BeanSpring) fabrica.getBean("miBean");
		System.out.println("Mensaje: "+miBean.getMensaje());
		

	}

}
