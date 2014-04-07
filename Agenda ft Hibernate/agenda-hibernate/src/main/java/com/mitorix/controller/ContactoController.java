package com.mitorix.controller;

import java.util.Map;

import javax.ejb.EJB;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mitorix.entity.Contacto;
import com.mitorix.service.ContactoService;

@Controller
public class ContactoController {

	@EJB
	private ContactoService contactoService;

	@RequestMapping("/index")
	public String listaContactos(Map<String, Object> map) {
		map.put("contacto", new Contacto());
		map.put("contactoList", contactoService.contactos());
		return "contacto";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addContacto(@ModelAttribute("contacto") Contacto contacto,
			BindingResult result) {
		contactoService.guardarContacto(contacto);
		return "redirect:/index";
	}

	@RequestMapping("/delete/{idContacto}")
	public String eliminarContacto(@PathVariable("idContacto") Long idContacto) {
		contactoService.eliminarContacto(idContacto);
		return "redirect:/index";
	}
}
