package it.beije.makemake.restcontroller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.makemake.ecommerce.User;
import it.beije.makemake.repository.UserRepository;
import it.beije.makemake.service.EcommerceService;

@RestController
@RequestMapping("api")
public class EcommerceRestController {
	@Autowired
	private EcommerceService ecommerceService;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/utente/{id}")
	public @ResponseBody User getUser(@PathVariable(name = "id") Integer id) {
		
		System.out.println("GET getUser : " + id);
		
		User utente = ecommerceService.findById(id);
		
		System.out.println("user : " + utente);
		
		return utente;
	}
	@GetMapping("/utenti")
	public @ResponseBody List<User> getAllUser() {
		
		System.out.println("GET getAllUser : " );
		
		List<User> utenti = userRepository.findAll();
		
		System.out.println("user : " + utenti);
		
		return utenti;
	}
	
	
	
	

}
