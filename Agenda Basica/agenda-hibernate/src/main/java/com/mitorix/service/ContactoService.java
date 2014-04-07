package com.mitorix.service;

import java.util.ArrayList;

import com.mitorix.entity.Contacto;

public interface ContactoService {
	
	public void guardarContacto(Contacto contacto);
	
	public ArrayList<Contacto> contactos();
	
	public void eliminarContacto(Long idContacto);
}
