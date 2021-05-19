package it.beije.makemake.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.makemake.User;
import it.beije.makemake.service.AuthService;

@Controller
public class AuthController {
	
	@Autowired AuthService as;

	@RequestMapping(path = "/getLogin", method = RequestMethod.GET)
	public String login() {
		return "ECLogin";
	}
	
	@RequestMapping(path = "/postLogin", method = RequestMethod.POST)
	public String postLogin(Model model, 
			@RequestParam String username, 
			@RequestParam String password) {
		
		if(username == "" || password == "") {
			model.addAttribute("errore", "Insert all credentials.");
			return "ECLogin";
		}
		else {
			User user;
			user = as.getUserByUsernameAndPassword(username, password);
		
			if(user == null) {
				model.addAttribute("errore", "You have to register.");
				return "ECLogin";
			}
			model.addAttribute("user", user);
			return "home";
		}
	}
	
	@RequestMapping(path = "/register", method = RequestMethod.GET)
	public String getRegister() {
		return "registration";
	}
	
	@RequestMapping(path = "/postRegister", method = RequestMethod.POST )
	public String postRegister(Model model,
			@RequestParam String username,
			@RequestParam String password,
			@RequestParam String name,
			@RequestParam String surname) {
		
		if(username == "" || password == "" || name == "" || surname == "") {
			model.addAttribute("errore", "Insert all credentials.");
			return "registration";
		}
		List<User> users = as.getAll();
		for(User u : users) {
			if(username.equals(u.getUsername())) {
				model.addAttribute("errore", "You're already registered.");
				return "registration";
			}
		}
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setName(name);
		user.setSurname(surname);
		as.addUser(user);
		model.addAttribute("user", user);
		return "home";
	}
	
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public String getHome() {
		return "home";
	}
}
