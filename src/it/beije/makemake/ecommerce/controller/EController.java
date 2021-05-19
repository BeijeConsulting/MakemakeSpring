package it.beije.makemake.ecommerce.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import it.beije.makemake.ecommerce.entity.*;
import it.beije.makemake.ecommerce.repository.*;
import it.beije.makemake.ecommerce.service.*;

@RestController

public class EController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderService orderService;
	
	// metodi user
	@GetMapping("/user/{userId}")
 	public @ResponseBody User getUser(@PathVariable(name = "userId") Integer id) {
		System.out.println("getUserId: " + id);
		Optional<User> a = null;
		if (id != null) {
			a = userRepository.findById(id);
			return a.isPresent() ? a.get() : null;
		} else {
			System.out.println("user null!");
			return null;
		}
	}
	@GetMapping("/user/all")
	public @ResponseBody List<User> getAllUser() {
		List<User> a = null;
		a = userRepository.findAll();
		System.out.println("all user:");
		System.out.println(a);
		return a;

	}
	@PostMapping("/user/insert")
	public @ResponseBody User insertUser(@RequestBody User parametro) {
		if( parametro != null) {
			userRepository.save(parametro);	
		}
		return parametro;
	}
	@PutMapping("/user/update/{userId}")
	public @ResponseBody User updateUser(@PathVariable(name = "userId") Integer id ,@RequestBody User newUser ){
		if(id != null) {
			Optional<User> comodo = userRepository.findById(id);
			if(comodo != null) {
				User a = comodo.get();
				a.setName(newUser.getName());
				a.setPassword(newUser.getPassword());
				a.setSurname(newUser.getSurname());
				a.setUsername(newUser.getUsername());
				
				System.out.println(a);
				userRepository.save(a);
				return a;
			}else
				return null;

		}else
			return null;
		
	}
	@DeleteMapping("/user/delete/{userId}")
	public @ResponseBody Map<String, String> deleteUser(@PathVariable(name = "userId") Integer id  ) {
		HashMap<String, String> response = new HashMap<String, String>();
		if(id != null) {
			 userRepository.deleteById(id);
			
			response.put("messaggio: ","Utente cancellato.");
			
		}else {
			response.put("messaggio: ","Utente non esistente.");
		}
			return response;
	}
	
	// metodi product 
	@GetMapping("/product/{productId}")
	public @ResponseBody Product getProduct(@PathVariable(name = "productId") Integer id) {
		System.out.println("getProductId: " + id);
		Optional<Product> a = null;
		if (id != null) {
			a = productRepository.findById(id);
			return a.isPresent() ? a.get() : null;
		} else {
			System.out.println("product null!");
			return null;
		}
	}
	@GetMapping("/product/all")
	public @ResponseBody List<Product> getAllProduct() {
		List<Product> a = null;
		a = productRepository.findAll();
		System.out.println("all product:");
		System.out.println(a);
		return a;

	}
	@PostMapping("/product/insert")
	public @ResponseBody Product insertProduct(@RequestBody Product parametro) {
		if( parametro != null) {
			productRepository.save(parametro);	
		}
		return parametro;
	}	
	@PutMapping("/product/update/{productId}")
	public @ResponseBody Product updateProduct(@PathVariable(name = "productId") Integer id ,@RequestBody Product newProduct ){
		if(id != null) {
			Optional<Product> comodo = productRepository.findById(id);
			if(comodo != null) {
				Product a = comodo.get();
				a.setName(newProduct.getName());
				a.setBrand(newProduct.getBrand());
				a.setDescription(newProduct.getDescription());
				a.setImage(newProduct.getImage());
				a.setPrice(newProduct.getPrice());
				a.setQuantity(newProduct.getQuantity());
				
				System.out.println(a);
				productRepository.save(a);
				return a;
			}else
				return null;

		}else
			return null;
		
	}
	@DeleteMapping("/product/delete/{productId}")
	public @ResponseBody Map<String, String> deleteProduct(@PathVariable(name = "productId") Integer id  ) {
		HashMap<String, String> response = new HashMap<String, String>();
		if(id != null) {
			productRepository.deleteById(id);
			
			response.put("messaggio: ","Prodotto cancellato.");
			
		}else {
			response.put("messaggio: ","Prodotto non esistente.");
		}
			return response;
	}

	//metodi order
	@PostMapping("/order/do/{userId}")
	public @ResponseBody Order createOrder(@PathVariable(name = "userId") Integer id ,@RequestBody List<OrderItem> lista ){
		if(id != null && lista != null && !lista.isEmpty()) {
			return orderService.doOrder(lista, id);
			
		}else
			return null;
		
	}
	

}
