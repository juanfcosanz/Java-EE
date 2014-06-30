package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import mx.com.gm.jdbc.Persona;
import mx.com.gm.jdbc.PersonaDao;

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
			System.out.println("");
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
	
	@Test
	public void testContarPersonasPorNombre(){
		System.out.println("");
		logger.info("Cargando Test ContarPersonasPorNombre");
		
		String nombre = "Juan";
		Persona personaEjemplo = new Persona();
		personaEjemplo.setNombre(nombre);
		
		int noPersonasEncontradas = personaDao.contadorPersonasPorNombre(personaEjemplo);
		logger.info("Numero de personas encontradas por nombre '"+nombre+"': "+noPersonasEncontradas);
		
		assertEquals(1, noPersonasEncontradas);
		logger.info("Fin del test ContarPersonasPorNombre");
	}
	
	@Test
	public void testEncontrarPersonasPorId(){
		try{
		System.out.println("");
		logger.info("Cargando Test EncontrarPersonasPorID");
		int idPersona = 1;
		Persona persona = personaDao.findPersonaById(idPersona);
		
		//segun la persona encontrada, deberia ser la misma que el registro 1
		assertEquals("Admin", persona.getNombre());
		
		//imprimimos todo el objeto
		logger.info("Persona recuperada (id="+idPersona+"): "+persona);
		logger.info("Fin del test EncontrarPersonaPorID");
		}catch(Exception e){
			logger.info("Error JDBC ",e);
		}
	}
	
	@Test
	public void testInsertarPersona(){
		try{
			System.out.println("");
			logger.info("Cargando test Insertar Persona");
			assertEquals(2, personaDao.contadorPersonas());
			
			Persona persona = new Persona();
			persona.setNombre("Carlos");
			persona.setApePaterno("Romero");
			persona.setApeMaterno("Esparza");
			persona.setEmail("carlos.romero@gmail.com");
			personaDao.insertPersona(persona);
			
			//recuperamos el registro por su email
			persona = personaDao.getPersonaByEmail(persona);
			logger.info("Persona insertada: "+persona);
			
			// deberiamos recuperar 4 personas
			assertEquals(3, personaDao.contadorPersonas());
			logger.info("Fin del test Insertar Persona");
		}catch(Exception e){
			logger.info("Error JDBC ",e);
		}
	}
	
	@Test
	public void testActualizarPersona(){
		try{
			System.out.println("");
			logger.info("Cargando test Actualizar Persona");
			
			long idPersona = 1;
			Persona persona =  personaDao.findPersonaById(idPersona);
			logger.info("Persona a modificar: (id="+idPersona+"): "+persona);
			
			//actualizamos el nombre y apeMaterno
			persona.setNombre("Administrador");
			persona.setApeMaterno("Sistemas");
			personaDao.updatePersona(persona);
			
			//Volvemos a leer el usuario
			personaDao.findPersonaById(idPersona);
			
			//segun la persona recuperada, deberia ser la misma que el registro 1
			assertEquals("Administrador", persona.getNombre());
			//imprimimos el objeto
			logger.info("Persona modificada: (id="+idPersona+"): "+persona);			
			logger.info("Fin del test Insertar Persona");
		}catch(Exception e){
			logger.info("Error JDBC ",e);
		}
	}
	
	@Test
	public void testEliminarPersona(){
		try{
			System.out.println("");
			logger.info("Cargando test Eliminar Persona");
			
			//definimos el idPersona que vamos a eliminar
			long idPersona = 2;
			Persona persona = personaDao.findPersonaById(idPersona);
			logger.info("Persona a eliminar (id="+idPersona+"): "+persona);
			
			//eliminamos la persona recuperada
			personaDao.deletePersona(persona);
			persona = personaDao.findPersonaById(idPersona);
			
			//deberia regresar nulo al buscar la persona 2
			assertNull(persona);
			
			//imprimimos todo el objeto
			logger.info("Nuevo listado de personas");
			
			List<Persona> personas = personaDao.findAllPersonas();
			int contadorPersonas = 0;
			for (Persona persona2 : personas) {
				logger.info("Persona: "+persona2);
				contadorPersonas++;
			}
			
			//segun el nuemro de personas recuperadas, deberia ser el mismo de la tabla
			assertEquals(contadorPersonas, personaDao.contadorPersonas());
			
			logger.info("Fin del test eliminar Persona");
		}catch(Exception e){
			logger.info("Error JDBC ",e);
		}
	}
}
