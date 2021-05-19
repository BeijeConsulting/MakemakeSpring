package it.beije.makemake.controller.mycontrollers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.makemake.ecommerce.User;
import it.beije.makemake.repository.UserRepository;


@Controller
public class LoginController {
	
	@Autowired
	private UserRepository userRepository;
	
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
		}else {
			User u = userRepository.findByUsernameAndPassword(username,password);
			if(u==null) {
				model.addAttribute("errore","<h6 style = 'color:red>CREDENZIALI ERRATE");
				return "mylogin";
			}/*else {
				model.addAttribute("loggedUser", u);
				String entryPoint = (String) model.getAttribute("entryPoint");
				if(entryPoint == null) {
					return "Welcome";
				}else {
					return entryPoint;
				}
			}*/
			return "home";
		
		}
		

	}
}
