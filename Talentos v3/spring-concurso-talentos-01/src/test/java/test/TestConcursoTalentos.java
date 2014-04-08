package test;

import static org.junit.Assert.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import concursantes.Concursante;
import concursantes.Malabarista;
import concursantes.Musico;

public class TestConcursoTalentos {
	
	Log logger = LogFactory.getLog("Iniciando TestConcursoTalentos");
	private Concursante malabarista1;
	private Concursante malabarista2;
	private Concursante musico1;
	private Concursante musico2;
	
	@Before
	public void before(){
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		malabarista1 = (Concursante) ctx.getBean("solei");
		malabarista2 = (Concursante) ctx.getBean("soleiRecitador");
		musico1 = (Concursante) ctx.getBean("jasonPiano");
		musico2 = (Concursante) ctx.getBean("jasonSax");
	}
	@Test
	public void test() {
		logger.info("Inicio de ejecutar Malabarista");
		int noPelotas = 10;
		malabarista1.ejecutar();
		assertEquals(noPelotas, ((Malabarista) malabarista1).getPelotas());
		logger.info("Fin de Malabarista");
		logger.info("Inicio de MalabaristaRecitador");
		
		noPelotas = 15;
		malabarista2.ejecutar();
		assertEquals(noPelotas, ((Malabarista) malabarista2).getPelotas());
		logger.info("Fin de Malabarista Recitador");
		
		logger.info("Inicio de ejecutar Pianista");
		String cancion = "Noche de Paz";
		musico1.ejecutar();
		assertEquals(cancion, ((Musico) musico1).getCancion());
		logger.info("Fin de Pianista");
		
		logger.info("Inicio de ejecutar Saxofonista");
		cancion = "Equinox";
		musico2.ejecutar();
		assertEquals(cancion,((Musico) musico2).getCancion());
		logger.info("Fin de Saxofonista");
		
	}

}
