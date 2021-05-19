package it.beije.makemake.ecommerce.rest;



import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.makemake.ecommerce.entity.Order;
import it.beije.makemake.ecommerce.entity.OrderItem;
import it.beije.makemake.ecommerce.entity.Product;
import it.beije.makemake.ecommerce.entity.User;
import it.beije.makemake.ecommerce.repository.OrderItemRepository;
import it.beije.makemake.ecommerce.repository.OrderRepository;
import it.beije.makemake.ecommerce.repository.ProductRepository;
import it.beije.makemake.ecommerce.repository.UserRepository;
import it.beije.makemake.ecommerce.service.OrderItemService;
import it.beije.makemake.ecommerce.service.OrderService;
import it.beije.makemake.ecommerce.service.UserService;

@RestController
@RequestMapping("rest_api")
public class EcommerceRestController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(path="/user/{userId}", method=RequestMethod.GET)
	public @ResponseBody User getUser(
			@PathVariable(name="userId") Integer id)
	{
		Optional<User> user = null;
		
		if(id != null) {
			user = userRepository.findById(id);
			return (user.isPresent()?user.get():null);
		}else {
			return null;
		}
	}
	
	@RequestMapping(path="/user/all", method=RequestMethod.GET)
	public @ResponseBody List<User> getUsers(){
		return userRepository.findAll();
	}
	
	@Transactional
	@RequestMapping(path="/user/registration", method=RequestMethod.POST)
	public @ResponseBody User insertUser(
			@RequestBody User newData)
	{
		
		if(newData != null) {
			userRepository.save(newData);
		}
		
		return newData;
	}
	
	@Transactional
	@RequestMapping(path="/user/update/{userId}", method=RequestMethod.PUT)
	public @ResponseBody User updateUser(
			@PathVariable(name="userId") Integer id, @RequestBody User update)
	{
		Optional<User> user = userRepository.findById(id);
		User updated = null;
		
		if(user.isPresent()) {
			updated = user.get();
			
			updated.setName(update.getName());
			updated.setSurname(update.getSurname());
			updated.setUsername(update.getUsername());
			
			userRepository.save(updated);
		}
		
		return updated;
	}
	
	@Transactional
	@RequestMapping(path="/user/delete/{userId}", method=RequestMethod.DELETE)
	public @ResponseBody Map<String, String> deleteUser(
			@PathVariable(name="userId") Integer id)
	{
		Map<String, String> message = new HashMap<String, String>();
		
		if(id != null) {
			userRepository.deleteById(id);
			message.put("message", "contatto cancellato");
		}else {
			message.put("message", "contatto inesistente");
		}
		
		return message;
	}
	
	
	
	@RequestMapping(path="/product/{productId}", method=RequestMethod.GET)
	public @ResponseBody Product getProduct(
			@PathVariable(name="productId") Integer id)
	{
		Optional<Product> product = null;
		
		if(id != null) {
			product = productRepository.findById(id);
			return (product.isPresent()?product.get():null);
		}else {
			return null;
		}
	}
	
	@RequestMapping(path="/product/all", method=RequestMethod.GET)
	public @ResponseBody List<Product> getProducts(){
		return productRepository.findAll();
	}
	
	@Transactional
	@RequestMapping(path="/product/registration", method=RequestMethod.POST)
	public @ResponseBody Product insertProduct(
			@RequestBody Product newData)
	{
		
		if(newData != null) {
			productRepository.save(newData);
		}
		
		return newData;
	}
	
	@RequestMapping(path="/product/update/{productId}", method=RequestMethod.PUT)
	public @ResponseBody Product updateProduct(
			@PathVariable(name="productId") Integer id, @RequestBody Product update)
	{
		Optional<Product> product = productRepository.findById(id);
		Product updated = null;
		
		if(product.isPresent()) {
			updated = product.get();
			
			updated.setDescription(update.getDescription());
			updated.setBrand(update.getBrand());
			updated.setQuantity(update.getQuantity());
			updated.setPrice(update.getPrice());
			
			productRepository.save(updated);
		}
		
		return updated;
	}

	@Transactional
	@RequestMapping(path="/product/delete/{productId}", method=RequestMethod.DELETE)
	public @ResponseBody Map<String, String> deleteProduct(
			@PathVariable(name="productId") Integer id)
	{
		Map<String, String> message = new HashMap<String, String>();
		
		if(id != null) {
			productRepository.deleteById(id);
			message.put("message", "prodotto cancellato");
		}else {
			message.put("message", "prodotto inesistente");
		}
		
		return message;
	}
	
	
	
	@RequestMapping(path="/order/{orderId}", method=RequestMethod.GET)
	public @ResponseBody Order getOrder(
			@PathVariable(name="orderId") Integer id)
	{
		Optional<Order> order = null;
		
		if(id != null) {
			order = orderRepository.findById(id);
			return (order.isPresent()?order.get():null);
		}else {
			return null;
		}
	}
	
	@RequestMapping(path="/order/all/{userId}", method=RequestMethod.GET)
	public @ResponseBody List<Order> getOrders(
			@PathVariable(name="userId") Integer id){
		
		return orderRepository.findByUserId(id);
	}
	
	
	@Transactional
	@RequestMapping(path="/order/registration/{userId}", method=RequestMethod.POST)
	public @ResponseBody Order insertOrder(
			@RequestBody List<OrderItem> newData,
			@PathVariable(name="userId") Integer id)
	{
		
		
		if(newData != null && !newData.isEmpty()) {
			return orderService.insertOrder(newData, id);
		}else {
			return null;
		}
		
		
	}
	

}
