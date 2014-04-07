package com.mitorix.dao;

import java.util.ArrayList;

import com.mitorix.entity.Contacto;

public interface ContactoDao {
	
	public void guardarContacto(Contacto contacto);
	
	public ArrayList<Contacto> contactos();
	
	public void eliminarContacto(Long idContacto);
	
}
