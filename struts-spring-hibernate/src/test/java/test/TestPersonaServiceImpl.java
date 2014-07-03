package test;

import static org.junit.Assert.*;

import java.util.List;

import mx.com.gm.dao.PersonaDao;
import mx.com.gm.entity.Persona;
import mx.com.gm.servicio.PersonaService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config.xml" })
public class TestPersonaServiceImpl {

	private static Log logger = LogFactory.getLog("TestPersonaServiceImpl");

	@Autowired
	private PersonaService personaService;

	@Autowired
	private PersonaDao personaDao;

	/*
	 * Debido a que los metodos marcados como @rTrasccion, en prubas unitarias
	 * se ejecutan peroa l fnasl hacen un rollback
	 */
	@Test
	@Transactional
	public void deberiaMostrarPersonas() {
		try {
			System.out.println();
			logger.info("Inicio del test deberiaMostarPersonas");
			int contadorPersonas = this.desplegarPersonas();
			// segun el no. de personas recuperada, deberia ser al mismo de la
			// tabla
			assertEquals(contadorPersonas, personaDao.contadorPersonas());
			logger.info("Fin del test deberiaMostarPersonas");
		} catch (Exception e) {
			logger.info("Error JDBC" + e);
		}
	}

	private int desplegarPersonas() {
		List<Persona> personas = personaService.listarPersonas();
		int contPersonas = 0;
		for (Persona persona : personas) {
			logger.info("Persona: " + persona);
			contPersonas++;
		}
		return contPersonas;
	}

	@Test
	@Transactional
	public void testoperaciones() {
		try {
			System.out.println();
			logger.info("Inicio del test testoperaciones");

			Persona newPersona = new Persona();
			newPersona.setNombre("Andrea");
			newPersona.setApePaterno("Lara");
			newPersona.setEmail("andrea@gmail.com");
			personaService.agregraPersona(newPersona);
			// deberia haber 4 personas

			assertEquals(4, personaDao.contadorPersonas());

			// Actualizamos la persona con id=1
			Persona persona2 = personaService.recuperarPersona(new Persona(1));
			persona2.setNombre("Administrador");
			personaService.modificarPersona(persona2);
			this.desplegarPersonas();
			logger.info("Fin del test testoperaciones");
		} catch (Exception e) {
			logger.info("Error JDBC " + e);
		}
	}

	public void testComprobarOperaciones() {
		try {

			logger.info("Fin del test testComprobarOperaciones");
			// deberia haber 3 personas
			assertEquals(3, personaDao.contadorPersonas());
			this.desplegarPersonas();
			logger.info("Fin del test testComprobarOperaciones");
		} catch (Exception e) {
			logger.info("Error JDBC " + e);
		}
	}
}
