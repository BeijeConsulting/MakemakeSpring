package it.beije.makemake.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.beije.makemake.User;
import it.beije.makemake.Order;
import it.beije.makemake.Product;
import it.beije.makemake.User;
import it.beije.makemake.repository.OrderRepository;
import it.beije.makemake.repository.ProductRepository;
import it.beije.makemake.repository.UserRepository;
import it.beije.makemake.service.OrderItemService;
import it.beije.makemake.service.OrderService;
import it.beije.makemake.service.ProductService;
import it.beije.makemake.service.UserService;

@RestController

public class EcommerceRestController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderService orderService;

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderItemService orderItemService;
	
//	@RequestMapping(path = "/login_ecommerce", method = RequestMethod.GET)
//	public String user() {
//
//		System.out.println("GET login_ecommerce");
//
//		return "login_ecommerce";
//	}

//	@RequestMapping(path = "/login_ecommerce", method = RequestMethod.POST)
//	public String user(Model model, HttpServletRequest request, @RequestParam(required = false) String username,
//			@RequestParam(required = false) String password) {
//
//		HttpSession session = request.getSession();
//		System.out.println("POST login_ecommerce");
//
//		try {
//			User u = userService.findByUsernameAndPassword(username, password);
//			session.setAttribute("loggedUser", u);
//			System.out.println(u);
//			return "benvenuto";
//		} catch (NullPointerException e) {
//			model.addAttribute("errore", "Username o password errati");
//			return "login_ecommerce";
//		}
//	}
	
	//UTENTE_____________________________________________________________________________________________________
	
	@GetMapping("/users")
	public @ResponseBody List<User> getUsers() {
		
		System.out.println("GET getUsers");
		
		List<User> users = userRepository.findAll();
		
		System.out.println("utenti : " + users.size());
		
		return users;
	}
	@GetMapping("/user/{id}")
	public @ResponseBody User getUser(@PathVariable(name = "id") Integer id) {
		
		System.out.println("GET getUser : " + id);
		
		User u = userRepository.findById(id).orElse(null);
		
		System.out.println("contatto : " + u);
		
		return u;
	}
	
	@Transactional
	@PostMapping("/user")
	public User insertUser(@RequestBody User u) {
		System.out.println("POST User");
		
		System.out.println(" User : " + u);
		
		userRepository.save(u);
		
		return u;
	}
	
	@Transactional
	@PutMapping("/user/{id}")
	public @ResponseBody User updateUser(@PathVariable(name = "id") Integer id, @RequestBody User newData) {
		
		System.out.println("PUT updateContatto : " + id);
		
//		if (id == newData.getId())...
		
		User u = userRepository.findById(id).orElse(null);
		
		u.setUsername(newData.getUsername());
		u.setSurname(newData.getSurname());
		u.setName(newData.getName());
		u.setPassword(newData.getPassword());
		
		userRepository.save(u);		
		System.out.println("contatto : " + u);
		
		return u;
	}
	@DeleteMapping("/user/{id}")
	public @ResponseBody Map<String, String> deleteUser(@PathVariable(name = "id") Integer id) {
		
		System.out.println("DELETE deleteUser : " + id);
		
		userRepository.deleteById(id);
		
		HashMap<String, String> response = new HashMap<String, String>();
		
		response.put("message", "Utente cancellato");
		
		return response;
	}
	//ORDINE_____________________________________________________________________________________________________

	@GetMapping("/orders")
	public @ResponseBody List<Order> getOrders() {
		
		System.out.println("GET getOrders");
		
		List<Order> users = orderRepository.findAll();
		
		System.out.println("utenti : " + users.size());
		
		return users;
	}
	@GetMapping("/order/{id}")
	public @ResponseBody Order getOrder(@PathVariable(name = "id") Integer id) {
		
		System.out.println("GET getOrder : " + id);
		
		Order o = orderRepository.findById(id).orElse(null);
		
		System.out.println("ordine : " + o);
		
		return o;
	}
	
	@Transactional
	@PostMapping("/order")
	public Order insertOrdini(@RequestBody Order o) {
		System.out.println("POST Order");
		
		System.out.println(" Order : " + o);
		
		orderRepository.save(o);
		
		return o;
	}
	
	@Transactional
	@PutMapping("/order/{id}")
	public @ResponseBody Order updateOrdine(@PathVariable(name = "id") Integer id, @RequestBody Order newData) {
		
		System.out.println("PUT updateOrder : " + id);
		
//		if (id == newData.getId())...
		
		Order o = orderRepository.findById(id).orElse(null);
		
		o.setDate(newData.getDate());
		o.setUserId(newData.getUserId());
		o.setStatus(newData.getStatus());
		o.setTotal(newData.getTotal());
		
		orderRepository.save(o);		
		System.out.println("order : " + o);
		
		return o;
	}
	@DeleteMapping("/order/{id}")
	public @ResponseBody Map<String, String> deleteOrder(@PathVariable(name = "id") Integer id) {
		
		System.out.println("DELETE deleteOrder : " + id);
		
		orderRepository.deleteById(id);
		
		HashMap<String, String> response = new HashMap<String, String>();
		
		response.put("message", "Ordine cancellato");
		
		return response;
	}
	
	//PRODOTTO_____________________________________________________________________________________________________

		@GetMapping("/products")
		public @ResponseBody List<Product> getProducts() {
			
			System.out.println("GET getProductss");
			
			List<Product> products = productRepository.findAll();
			
			System.out.println("Prodotti : " + products.size());
			
			return products;
		}
		@GetMapping("/product/{id}")
		public @ResponseBody Product getProduct(@PathVariable(name = "id") Integer id) {
			
			System.out.println("GET getProduct : " + id);
			
			Product p = productRepository.findById(id).orElse(null);
			
			System.out.println("prodotto : " + p);
			
			return p;
		}
		
		@Transactional
		@PostMapping("/product")
		public Product insertProduct(@RequestBody Product p) {
			System.out.println("POST Product");
			
			System.out.println(" Product : " + p);
			
			productRepository.save(p);
			
			return p;
		}
		
		@Transactional
		@PutMapping("/product/{id}")
		public @ResponseBody Product updateProduct(@PathVariable(name = "id") Integer id, @RequestBody Product newData) {
			
			System.out.println("PUT updateProduct : " + id);
			
//			if (id == newData.getId())...
			
			Product p = productRepository.findById(id).orElse(null);
			
			p.setName(newData.getName());
			p.setBrand(newData.getBrand());
			p.setDescription(newData.getDescription());
			p.setPrice(newData.getPrice());
			p.setImage(newData.getImage());
			p.setQuantity(newData.getQuantity());
			
			productRepository.save(p);		
			System.out.println("prodotto : " + p);
			
			return p;
		}
		@DeleteMapping("/product/{id}")
		public @ResponseBody Map<String, String> deleteProduct(@PathVariable(name = "id") Integer id) {
			
			System.out.println("DELETE deleteProduct : " + id);
			
			productRepository.deleteById(id);
			
			HashMap<String, String> response = new HashMap<String, String>();
			
			response.put("message", "Prodotto cancellato");
			
			return response;
		}

}
