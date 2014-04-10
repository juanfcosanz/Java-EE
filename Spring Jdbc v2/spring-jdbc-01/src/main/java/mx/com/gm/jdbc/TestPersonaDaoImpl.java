package mx.com.gm.jdbc;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:datasource-test.xml",
		"classpath:applicationContext.xml" })
public class TestPersonaDaoImpl {
	
	Log logger = LogFactory.getLog("Inicando TestPersonaDao");
	
	@Autowired
	private PersonaDao personaDao;
	
	@Test
	public void testMostrarPersonas() {
		try {
			logger.info("Cargando Test Mostrar Personas");
			List<Persona> personas = personaDao.findAllPersonas();
			int contadorPersonas = 0;
			for (Persona persona : personas) {
				logger.info("Persona: "+persona);
				contadorPersonas++;
			}
			//segun el numero de personas recuperadas, deberian ser el mismo de la tabla
			assertEquals(contadorPersonas,personaDao.contadorPersonas());
			logger.info("Fin del Test MostrarPersonas");
		} catch (Exception e) {
			logger.info("Error JDBC ",e);
		}
	}

}
