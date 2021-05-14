package it.beije.makemake.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.makemake.Order;
import it.beije.makemake.User;
import it.beije.makemake.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository ;

	public User save(User user) {
		return userRepository.save(user);
	}

	public User findByUsernameAndPassword(String username, String password) throws NullPointerException {
		if(username != null && password != null && username.length() > 0 && password.length() > 0) {
			User u = userRepository.findByUsernameAndPassword(username, password);
			if(u!=null)
				return u;
			else {System.out.println("ciao");
				throw new NullPointerException("Log errato");
				}
			}else {
			throw new NullPointerException("Log errato");
		}
		
	}
	

}
