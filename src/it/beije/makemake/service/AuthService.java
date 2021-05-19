package it.beije.makemake.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.makemake.User;
import it.beije.makemake.repository.AuthRepository;

@Service
public class AuthService {
	
	@Autowired AuthRepository ar;
	
	public User getUserByUsernameAndPassword(String username, String password) {
		return ar.findByUsernameAndPassword(username, password);
	}
	
	public List<User> getAll(){
		return ar.findAll();
	}
	
	public void addUser(User user) {
		ar.save(user);
	}
	
	public User getUserById(Integer id) {
		Optional<User> opt = ar.findById(id);
		if(opt.isPresent()) {
			User user = opt.get();
			return user;
		}
		else {
			return null;
		}
	}
}
