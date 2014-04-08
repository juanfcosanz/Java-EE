package test;

import static org.junit.Assert.assertEquals;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import concursantes.Concursante;
import concursantes.Malabarista;
import concursantes.Musico;

//indicamos que vamos a corre un clase utilizando spring y junit4
@RunWith(SpringJUnit4ClassRunner.class)   
//indicamos la localizacion de nuestro archivo de la fabrica de spring
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestConcursoTalentos {
	
	Log logger = LogFactory.getLog("Iniciando TestConcursoTalentos");
	
	//recuperamos los beans utilizando las anotaciones
	@Autowired
	@Qualifier("solei")
	private Concursante malabarista1;
	@Autowired
	@Qualifier("soleiRecitador")
	private Concursante malabarista2;
	@Autowired
	@Qualifier("jasonPiano")
	private Concursante musico1;
	@Autowired
	@Qualifier("jasonSax")
	private Concursante musico2;
	
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
