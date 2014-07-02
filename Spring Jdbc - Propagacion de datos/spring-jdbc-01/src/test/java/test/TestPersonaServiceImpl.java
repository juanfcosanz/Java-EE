package test;

import static org.junit.Assert.*;

import java.util.List;

import mx.com.gm.jdbc.Persona;
import mx.com.gm.jdbc.PersonaDao;
import mx.com.gm.servico.PersonaService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:datasource-test.xml",
		"classpath:applicationContext.xml" })
public class TestPersonaServiceImpl {

	private static Log logger = LogFactory.getLog("TestPersonaServiceImpl");

	@Autowired
	private PersonaService personaService;
	@Autowired
	private PersonaDao personaDao;

	@Test
	// @Transactional //cuando se hacen pruebas unitarias es comun usar esta
	// anotacion para evitar que haga algun commit, haciendo un rollback y no
	// altera la tablas
	public void deberiaMostrarPersonas() {
		try {
			System.out.println();
			logger.info("Inicio del test");
			int contadorPersonas = this.desplegarPersonas();

			// segun el no. de personas recuperas, deberia ser el mismo de la
			// tabla
			assertEquals(contadorPersonas, personaDao.contadorPersonas());
			logger.info("Fin del test");
		} catch (Exception e) {
			logger.info("Error Servico ", e);
		}
	}

	private int desplegarPersonas() {
		List<Persona> personas = personaService.listarPersonas();
		int contadorPersonas = 0;
		for (Persona persona : personas) {
			logger.info("Personas: " + persona);
			contadorPersonas++;
		}
		return contadorPersonas;

	}

	@Test
	@Transactional// relizaremos un rollback
	public void testOperaciones() {
		try {
			System.out.println();
			logger.info("Iniciando testOperaciones");
			Persona persona1 = new Persona();
			persona1.setNombre("Andrea");
			//persona1.setNombre("Andrea111111111111111111111111111111111111111111111111111111111111111111111");
			persona1.setApePaterno("Lara");
			persona1.setEmail("dolgasanz@email.com");
			personaService.agregarPersona(persona1);

			// Deberiamos tener 4 personas
			assertEquals(4, personaDao.contadorPersonas());

			// Actualizamos la perosna con id=1
			Persona persona2 = personaService.recuperarPersona(new Persona(1));
			persona2.setNombre("Administrador");
			personaService.modificarPersona(persona2);

			this.desplegarPersonas();

			logger.info("Fin del testOperaciones");
			System.out.println();

		} catch (Exception e) {
			logger.info("Error testOperaciones", e);
		}
	}
	
	@Test
	public void compruebaOperaciones(){
		try{
			logger.info("Iniciando compruebaOperaciones");
			//deberiamos tener 3 personas ya que se hizo rollback antes
			assertEquals(3, personaDao.contadorPersonas());
			
			this.desplegarPersonas();
			
			logger.info("Fin compruebaOperaciones");
			
		}catch(Exception e){
			logger.info("Error Comprueba operaciones ", e);
		}
	}
}
