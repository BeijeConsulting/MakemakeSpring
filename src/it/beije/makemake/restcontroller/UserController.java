package it.beije.makemake.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.makemake.User;
import it.beije.makemake.repository.AuthRepository;
import it.beije.makemake.service.AuthService;

@RestController
@RequestMapping("api")
public class UserController {

	@Autowired 
	AuthService as;
	
	@Autowired
	AuthRepository ar;
	
	@GetMapping("/users")
	public @ResponseBody List<User> getAllUsers(){
		List<User> users = ar.findAll();
		return users;
	}
	
	@PutMapping("/updateUser/{id}")
	public User updateUser(@PathVariable(name = "id") Integer id, @RequestBody User newData) {
		User user = as.getUserById(id);
		if(user != null) {
			user.setUsername(newData.getUsername());
			user.setPassword(newData.getPassword());
			user.setName(newData.getName());
			user.setSurname(newData.getSurname());
		}
		return user;
	}
}
