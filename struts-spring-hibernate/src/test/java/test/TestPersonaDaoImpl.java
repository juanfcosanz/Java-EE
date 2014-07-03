package test;

import static org.junit.Assert.*;

import java.util.List;

import mx.com.gm.dao.PersonaDao;
import mx.com.gm.entity.Persona;

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
public class TestPersonaDaoImpl {

	private static Log logger = LogFactory
			.getLog("Inicando testPersonaDaoImpl");

	@Autowired
	private PersonaDao personaDao;

	@Test
	@Transactional
	// es nec para ejecutar el currentSession de Hibernate
	public void deberiaMostraPersonas() {
		try {
			System.out.println();
			logger.info("Inicio de deberiaMostrarPersonas");
			List<Persona> personas = personaDao.fillAllPersonas();
			int contPersonas = 0;

			for (Persona persona : personas) {
				logger.info("Persona :" + persona);
				contPersonas++;
			}
			// segun el no. de personas recuperdas, deberia ser el mismo de la
			// tabla
			assertEquals(contPersonas,personaDao.contadorPersonas());
			logger.info("Fin de deberiaMostrarPersonas");

		} catch (Exception e) {
			logger.info("Error JDBC " + e);
		}
	}
	
	@Test
	@Transactional
	public void deberiaBuscarPersonaById(){
		try{
			System.out.println();
			logger.info("Inicio de deberiaBuscarPersonaById");
			
			int idPersona = 1;
			Persona recuperada = personaDao.findPersonaById(idPersona);
			
			//segun la persona recuperada, deberia ser la mima
			assertEquals("Admin", recuperada.getNombre());
			logger.info("Persona recupeda (id= "+idPersona+"): "+recuperada);
			logger.info("Fin de deberiaBuscarPersonaById");
		}catch(Exception e){
			logger.info("Error JDBC "+ e);
			
		}
	}
	
	@Test
	@Transactional
	public void deberiaInsertarPersona(){
		try{
			System.out.println();
			logger.info("Inicio de deberiaInsertarPersona");
			Persona newPersona = new Persona();
			newPersona.setNombre("Calos");
			newPersona.setApePaterno("Romero");
			newPersona.setApeMaterno("Esparza");
			newPersona.setEmail("carlos@gmail.com");
			personaDao.insertPersona(newPersona);
			
			//recuperamos a la persina recien insertada por esu email
			newPersona = personaDao.getPersonaByEmail(newPersona);
			logger.info("Persona insertada: "+newPersona);
			
			//deberia de haber 4 personas
			assertEquals(4,personaDao.contadorPersonas());
			logger.info("Fin de deberiaInsertarPersona");
		}catch(Exception e){
			
		}
	}
}
