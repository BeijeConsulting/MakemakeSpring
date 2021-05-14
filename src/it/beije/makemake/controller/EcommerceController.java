package it.beije.makemake.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EcommerceController {

	@RequestMapping(path ="/viewProducts", method = RequestMethod.GET)
	public String viewProducts() {
		System.out.println("Post login");
		return "home";
	}
	
	
	
	@RequestMapping(path ="/login", method = RequestMethod.POST)
	public String registrati(@RequestParam String username,@RequestParam String password) {
		System.out.println("Post login");
		return "registrati";
	}
	

	@RequestMapping(path ="/login", method = RequestMethod.GET)
	public String registrati() {
		System.out.println("Post login");
		return "login";
	}
	
	@RequestMapping(path ="/menu_operazioni", method = RequestMethod.GET)
	public String menuOperazioni() {
		System.out.println("Get menu_operazioni");
		return "menu_operazione";
	}
	
	
	
	@RequestMapping(path ="/", method = RequestMethod.GET)
	public String welcome() {
		System.out.println("Get menu_operazioni");
		return "menu_operazione";
	}
	
}
