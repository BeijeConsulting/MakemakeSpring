package it.beije.makemake.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.makemake.User;
import it.beije.makemake.repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	
	public User findUserByUsernameAndPassword(String username , String password) {
		
		return userRepository.findUserByUsernameAndPassword(username, password);
		
	}
	

	public User addUser(String username , String password , String name , String surname) {
		
		User user = new User();
		
		if( name==null || surname==null) {
			user.setUsername(username);
			user.setPassword(password);
			userRepository.save(user);
			
		}else {
			user.setUsername(username);
			user.setPassword(password);
			user.setName(name);
			user.setSurname(surname);
			userRepository.save(user);
			
		}
	return user;
	}
	
	
}
