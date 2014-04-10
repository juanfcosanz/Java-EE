package mx.com.gm.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PersonaDaoImpl implements PersonaDao {

	// platillas JDBC a utilizar
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		// no es comun que se utilizen las 2 platillas,sin embargo es posible
		// la diferencia es el manejo de los parametros por indice o por nombre
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
	}

	// query con parametros por nombre
	// omitimos la PK ya que es autoincrementable
	private static final String SQL_INSERT_PERSONA = "INSERT INTO PERSONA (nombre, ape_paterno, ape_materno, email) "
			+ "VALUES (:nombre , :apePaterno, :apeMAterno, :email) ";

	// query con paramtero po Indice
	// private static final String SQL_INSERT_PERSONA =
	// "INSERT INTO PERSONA (username, password, fullname, email, update_by_email ) values (?,?,?,?,?)"
	
	//parametros por nombre
	private static final String SQL_UPDATE_PERSONA = 
		"UPDATE PERSONA set nombre = :nombre, ape_paterno = :apePaterno, ape_materno = :apeMaterno, email = :email "
		+ "WHERE id_persona = :idPersona";
	
	private static final String SQL_DELETE_PERSONA = 
			"DELETE FROM PERSONA WHERE id_persona = :idPersona";
			
	private static final String SQL_SELECT_PERSONA = "SELECT id_persona, nombre, ape_paterno, ape_materno, email FROM PERSONA";
	
	//parametros por indice
	private static final String SQL_SELECT_PERSONA_BY_ID = SQL_SELECT_PERSONA + " WHERE id_persona= ?";

	@Override
	public void insertPersona(Persona persona) {

	}

	@Override
	public void updatePersona(Persona persona) {

	}

	@Override
	public void deletePersona(Persona persona) {

	}

	@Override
	public Persona findPersonaById(long idPersona) {
		
		return null;
	}

	@Override
	public List<Persona> findAllPersonas() {
		//Esta consulta es equivalente a String sql = "SELECT * FROM PERSONA";
		RowMapper<Persona> personaRowRowMapper = ParameterizedBeanPropertyRowMapper.newInstance(Persona.class);
		return  jdbcTemplate.query(SQL_SELECT_PERSONA, personaRowRowMapper);
		
	}


	@Override
	public int contadorPersonasPorNombre(Persona persona) {
		return 0;
	}

	@Override
	public int contadorPersonas() {
		String sql = "SELECT count(*) FROM PERSONA";
		//retorna un entero del query
		return jdbcTemplate.queryForInt(sql);
		//si no tuvierasmos jdbcTemplate 
		//return namedParameterJdbcTemplate.getJdbcOperations().queryForInt(sql);
	}

	@Override
	public Persona getPersonaByEmail(Persona persona) {
		// TODO Auto-generated method stub
		return null;
	}

}
