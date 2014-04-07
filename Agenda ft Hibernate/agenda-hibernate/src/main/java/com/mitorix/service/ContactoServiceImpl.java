package com.mitorix.service;

import java.util.ArrayList;

import javax.ejb.EJB;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mitorix.dao.ContactoDao;
import com.mitorix.entity.Contacto;

@Service
public class ContactoServiceImpl implements ContactoService {

	@EJB
	private ContactoDao contactoDao;
	
	@Transactional
	public void guardarContacto(Contacto contacto) {
		contactoDao.guardarContacto(contacto);
	}

	@Transactional
	public ArrayList<Contacto> contactos() {
		return contactoDao.contactos();
	}

	@Transactional
	public void eliminarContacto(Long idContacto) {
		contactoDao.eliminarContacto(idContacto);
	}

}
