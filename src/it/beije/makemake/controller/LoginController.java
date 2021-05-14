package it.beije.makemake.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.makemake.User;
import it.beije.makemake.repository.UserRepository;
import it.beije.makemake.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	
//	mostra from
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String getLogin () {
		
	
	return "loginEcommerce";
	
	}
	
	@RequestMapping(path = "/getLogin", method = RequestMethod.POST)
	public String getLogin (@RequestParam ( required = false) String username , String password , Model model) {
		
		User user;
		
		if( username.length()==0 || password.length()==0) {
			
			model.addAttribute("errore" , "<h6 style='color:red'>Devi inserire le credeniali!</h6>");
			return "loginEcommerce";
			
		}else {
		
			user= userService.findUserByUsernameAndPassword(username, password);
		
			if((username.length()!=0 && password.length()!=0 ) && user==null) {
				
				model.addAttribute("error" , "<h6 style='color:red'>Credenziali errate!</h6>");
				return "loginEcommerce";
				
			} else {
				
				model.addAttribute("User" , user);
				return "homePage";
				
			}
		}
		
	
	}
	
	@RequestMapping(path = "/register", method = RequestMethod.GET)
	public String getRegister () {
		
	
	return "registrazioneEcommerce";
	
	}
	
	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public String getRegister (@RequestParam String username , String password , String name , String surname, Model model) {
		
		User user = new User();
		
		if( username.length()==0 || password.length()==0 ) {
			
			model.addAttribute("error" , "<h6 style='color:red'>Devi inserire Username e Password!!!</h6>");
			return "registrazioneEcommerce";
		}else {
			
			user = userService.addUser( username ,  password ,  name ,  surname);
			model.addAttribute("User" , user);
			
			return "homePage";
		}
		
	
	
	}
	
	
	
	
	
}