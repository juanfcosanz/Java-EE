package test;

import static org.junit.Assert.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:datasource-test.xml"})
public class TestJdbc {
	Log logger = LogFactory.getLog("Cargando Test Jdbc");
	
	@Autowired //inyectamos la referencia de jdbcTemplate de spring
	JdbcTemplate jdbcTemplate;  
	
	@Test
	public void testJdbc() {
		logger.info("Iniciando Test Jdbc");
		@SuppressWarnings("deprecation")
		//hacemos una consulta para saber el numero de personas
		int noPersonas = jdbcTemplate.queryForInt("select count(*) from persona");
		logger.info("Numero de personas: "+noPersonas);
		//validamos que tengamos 3 personas
		assertEquals(3, noPersonas);
		logger.info("Fin del test Jdbc");
			
		
	}

}
