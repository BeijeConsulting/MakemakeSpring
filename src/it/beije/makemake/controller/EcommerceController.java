package it.beije.makemake.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.makemake.ecommerce.Product;
import it.beije.makemake.ecommerce.User;
import it.beije.makemake.repository.ContattoRepository;
import it.beije.makemake.repository.ProductRepository;
import it.beije.makemake.repository.UserRepository;

public class EcommerceController {
	@Autowired
	private ContattoRepository contattoRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private UserRepository userRepository;
	

	
	@RequestMapping(path = "/loginE", method = RequestMethod.GET)
	public String user() {
		
		System.out.println("GET loginE");
		
		return "vedi_user";
	}
	@RequestMapping(path = "/loginE", method = RequestMethod.POST)
	public String user(Model model,
			@RequestParam(required = false) String username,
			@RequestParam(required = false) String password) {
		
		System.out.println("GET loginE");
		
		return "vedi_user";
	}
}