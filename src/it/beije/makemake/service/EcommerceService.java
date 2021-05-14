package it.beije.makemake.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.makemake.Contatto;
import it.beije.makemake.ecommerce.Product;
import it.beije.makemake.ecommerce.User;
import it.beije.makemake.repository.ProductRepository;
import it.beije.makemake.repository.UserRepository;

@Service
public class EcommerceService {

	@Autowired
	private  UserRepository userRepository;
	@Autowired
	private  ProductRepository productRepository;

	
	
	

	
	public User save(String username, String name, String surname, String password) {
		User user= new User();
		user.setSurname(surname);
		user.setName(name);
		user.setUsername(username);
		user.setPassword(password);

		return userRepository.save(user);	
	}
	
	public List<Product> showProduct(){
		return productRepository.findAll();		
	}
	public List<Product> findByName(String name){
		return productRepository.findByName(name);		
	}
	
}
