package mx.com.gm.dao;

import java.util.List;

import mx.com.gm.entity.Persona;

public interface PersonaDao {
	
	public void insertPersona(Persona persona);
	
	public void updatePersona(Persona persona);
	
	public void deletePersona(Persona persona);
	
	Persona findPersonaById(long idPersona);
	
	List<Persona> fillAllPersonas();
	
	long contadorPersonas();
	
	Persona getPersonaByEmail(Persona persona);
	
	

}
