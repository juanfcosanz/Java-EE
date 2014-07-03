package mx.com.gm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mx.com.gm.entity.Persona;

@Repository
public class PersonaDaoImpl implements PersonaDao {

	private SessionFactory sessionFactory;

	@Autowired
	public PersonaDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	/*
	 * Se nec de una transaccion activa, por ello la prueba unitaria utiliza
	 * 
	 * @Transaccion
	 */
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void insertPersona(Persona persona) {
		currentSession().saveOrUpdate(persona);
	}

	@Override
	public void updatePersona(Persona persona) {
		currentSession().update(persona);
	}

	@Override
	public void deletePersona(Persona persona) {
		currentSession().delete(persona);
	}

	@SuppressWarnings("unchecked")
	public List<Persona> fillAllPersonas() {
		// utilizamos HQL y especificamos que regrese una lista de obj.
		return currentSession().createQuery("from Persona").list();
	}

	@Override
	public Persona findPersonaById(long idPersona) {
		return (Persona) currentSession().get(Persona.class, idPersona);
	}

	@Override
	public long contadorPersonas() {
		// utilizamos una proyeccion para indicar el no. de reg. que tiene la
		// tabla
		Long contador = (Long) currentSession().createCriteria(Persona.class)
				.setProjection(Projections.rowCount()).uniqueResult();
		return contador.longValue();
	}

	@Override
	public Persona getPersonaByEmail(Persona persona) {
		// utilizamos un ejemplo de Criteria, donde buscara los elementod ! de
		// null y tomara para la busqueda
		Example ejemploPersona = Example.create(persona);
		return (Persona) currentSession().createCriteria(Persona.class)
				.add(ejemploPersona).uniqueResult();
	}
}
