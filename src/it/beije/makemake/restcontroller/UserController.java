package it.beije.makemake.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.makemake.ecommerce.Order;
import it.beije.makemake.ecommerce.User;
import it.beije.makemake.service.UserService;

@RestController
@RequestMapping("api")
public class UserController {
@Autowired
private UserService userService;

@GetMapping("/user/{id}")
public @ResponseBody User getContatto(@PathVariable(name = "id") Integer id ) {
	
	Optional<User> user = userService.findById(id);
	User utente = user.get();
	System.out.println("Utente : " + user);
	
	return utente;
}


/*@GetMapping("/user/{username:.+}")
public @ResponseBody User getUser(@PathVariable String username ) {
	
	System.out.println("GET getUser : " + username);
	
	User user = userService.findByUsername(username);
	
	System.out.println("Utente : " + user);
	
	return user;
}*/


}
