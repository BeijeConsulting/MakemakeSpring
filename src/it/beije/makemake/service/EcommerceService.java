package it.beije.makemake.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.makemake.ecommerce.User;
import it.beije.makemake.repository.UserRepository;

@Service
public class EcommerceService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private EcommerceService ecommerceService;


	public User findById(Integer id) {
		Optional<User> utente = userRepository.findById(id);
		return utente.isPresent() ? utente.get() : null;
 	}
	
	public List<User> findAllUser() {
		List<User> utenti = userRepository.findAll();
		return utenti;
 	}
	
	
	

}
