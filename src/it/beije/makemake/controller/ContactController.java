package it.beije.makemake.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.makemake.Contatto;
import it.beije.makemake.repository.ContattoRepository;

@Controller
public class ContactController {
	
	@Autowired
	private ContattoRepository cr;
	
	private List<Contatto> contacts = new ArrayList<Contatto>();

	@RequestMapping(path = "/contacts", method = RequestMethod.GET)
	public String getContactList(Model model) {
		contacts = cr.findAll();
		for(Contatto c : contacts) {
			System.out.println(c.toString());
		}
		model.addAttribute("contatti", contacts);
		return "contatti";
	}
}
