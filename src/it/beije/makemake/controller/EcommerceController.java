package it.beije.makemake.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.makemake.ecommerce.User;
import it.beije.makemake.service.EcommerceService;

@Controller
public class EcommerceController{
	
	@Autowired
	 private EcommerceService ecommerceService;
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String index() {
		System.out.println("GET index");
		
		return "login_ecommerce";
	}
	

	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String homepage(Model model,HttpServletRequest request,
			@RequestParam(required = false) String username,
			@RequestParam(required = false) String password) {
		request.getSession().setAttribute("username", username);
		System.out.println("POST homepage");
		System.out.println("GET user : ");
		return "homepage";
	}
	
	@RequestMapping(path = "/registrazione", method = RequestMethod.GET)
	public String registrazione() {
		System.out.println("GET registrazone");
		
		return "registrazione";
	}
	@RequestMapping(path = "/registrazione", method = RequestMethod.POST)
	public String registrazione(
			@RequestParam(required = false) String username,
			@RequestParam(required = false) String password,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String surname) {
		
		

		System.out.println("GET registrazone");
		ecommerceService.save(username, name, surname, password);
		return "login_ecommerce";
	}
	
	@RequestMapping(path = "/visualizza_prodotti", method = RequestMethod.GET)
	public String visualizza_prodotti(Model model) {
		System.out.println("GET visualizza_prodotti");
		model.addAttribute("prodotti", ecommerceService.showProduct());
		return "visualizza_prodotti";
	}
	
	
	
	
}