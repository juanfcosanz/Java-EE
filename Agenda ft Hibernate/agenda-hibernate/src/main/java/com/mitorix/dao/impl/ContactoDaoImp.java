package com.mitorix.dao.impl;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mitorix.dao.ContactoDao;
import com.mitorix.entity.Contacto;

@Repository
public class ContactoDaoImp implements ContactoDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void guardarContacto(Contacto contacto) {
		sessionFactory.getCurrentSession().save(contacto);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Contacto> contactos() {
		return (ArrayList<Contacto>) sessionFactory.getCurrentSession()
				.createQuery("from Contacto").list();
	}

	@Override
	public void eliminarContacto(Long idContacto) {
		Contacto contacto = (Contacto) sessionFactory.getCurrentSession().load(
				Contacto.class, idContacto);
		if (null != contacto) {
			sessionFactory.getCurrentSession().delete(contacto);
		}
	}

}
