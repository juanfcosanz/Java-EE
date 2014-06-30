package mx.com.gm.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mx.com.gm.jdbc.Persona;
import mx.com.gm.jdbc.PersonaDao;


@Service  //Definimos que es una clase de servicio
@Transactional(propagation=Propagation.SUPPORTS,  readOnly=true)  //agregamos el soporte transaccional
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaDao personaDao;

	public List<Persona> listarPersonas() {
		return personaDao.findAllPersonas();
	}

	
	public Persona recuperarPersona(Persona persona) {
		return personaDao.findPersonaById(persona.getIdPersona());
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void agregarPersona(Persona persona) {
		personaDao.insertPersona(persona);

	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void modificarPersona(Persona persona) {
		personaDao.updatePersona(persona);

	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void eliminarPersonas(Persona persona) {
		personaDao.deletePersona(persona);

	}

}
