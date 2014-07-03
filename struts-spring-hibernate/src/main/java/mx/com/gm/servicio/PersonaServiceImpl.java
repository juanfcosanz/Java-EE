package mx.com.gm.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.gm.dao.PersonaDao;
import mx.com.gm.entity.Persona;

//indicamos k esta clase es un beans de spring y que sus metodos sean transaccionales
@Service("personaService")
// lo hacemos para integrar spring con struts, mediante un nombre k inicia con
// minus..
@Transactional
// /agegamos la anotacion para que cuando los metodos se ejecuten inicien una
// transaccion
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaDao personaDao;

	@Override
	public List<Persona> listarPersonas() {
		return personaDao.fillAllPersonas();
	}

	@Override
	public Persona recuperarPersona(Persona persona) {

		return personaDao.findPersonaById(persona.getIdPersona());
	}

	@Override
	public void agregraPersona(Persona persona) {
		personaDao.insertPersona(persona);

	}

	@Override
	public void modificarPersona(Persona persona) {
		personaDao.updatePersona(persona);
	}

	@Override
	public void eliminarPersona(Persona persona) {
		personaDao.deletePersona(persona);
	}

}
