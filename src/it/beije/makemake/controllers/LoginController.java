package it.beije.makemake.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
@Controller
public class LoginController {
	
	@RequestMapping(path = "/mylogin", method = RequestMethod.GET)
	public String mylogin() {
		System.out.println("GET login");
		return "mylogin";
	}
	
	
	@RequestMapping (path = "/mylogin", method = RequestMethod.POST )
	public String mylogin(@RequestParam String username , @RequestParam String password,Model model) {
		
		if(username == null || username.length() == 0 || password == null || password.length() == 0 ) {
			model.addAttribute("errore", "<h6 style='color:red'>INSERIRE LE CREDENZIALI</h6>");
			return "mylogin";
		}/*else {
			Qui inserire Utente User u 
		}*/
		
		model.addAttribute("username", username);
		model.addAttribute("password", password);
		
		return "home";
	}
}
