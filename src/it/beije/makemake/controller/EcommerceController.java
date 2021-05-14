package it.beije.makemake.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import it.beije.makemake.User;
import it.beije.makemake.repository.UserRepository;

@Controller
public class EcommerceController {


	@Autowired
	private UserRepository userRepository;

	@RequestMapping(path = "/login_ecommerce", method = RequestMethod.GET)
	public String user() {

		System.out.println("GET login_ecommerce");

		return "login_ecommerce";
	}

	@RequestMapping(path = "/login_ecommerce", method = RequestMethod.POST)
	public String user(Model model,
			@RequestParam(required = false) String username,
			@RequestParam(required = false) String password) {

		System.out.println("POST login_ecommerce");
		
			 User user = userRepository.findByUsernameAndPassword(username, password);
			 System.out.println(user);
		if(user!= null) 
			return "benvenuto";
		return "login_ecommerce";
	}

}
