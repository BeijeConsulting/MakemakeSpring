package it.beije.makemake.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.makemake.Contatto;
import it.beije.makemake.ecommerce.EcommerceManager;
import it.beije.makemake.ecommerce.Order;
import it.beije.makemake.ecommerce.OrderItem;
import it.beije.makemake.ecommerce.Product;
import it.beije.makemake.ecommerce.User;
import it.beije.makemake.repository.OrderItemRepository;
import it.beije.makemake.repository.OrderRepository;
import it.beije.makemake.repository.ProductRepository;
import it.beije.makemake.repository.UserRepository;

@Service
public class EcommerceService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	public User save(String username, String name, String surname, String password) {
		User user = new User();
		user.setSurname(surname);
		user.setName(name);
		user.setUsername(username);
		user.setPassword(password);

		return userRepository.save(user);
	}

	public List<Product> showProduct() {
		return productRepository.findAll();
	}

	public List<Order> showOrder() {
		return orderRepository.findAll();
	}

	public List<OrderItem> showOrderItem() {
		return orderItemRepository.findAll();
	}

	public User findByUsernameAndPassword(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}

	public List<Product> findByName(String name) {
		return productRepository.findByName(name);
	}

	public List<Order> findByUserId(Integer userId) {
		return orderRepository.findByUserId(userId);
	}
	
	public List<OrderItem> findByOrderId(Integer orderId){
		return orderItemRepository.findByOrderId(orderId);
	}
	


	public  List<String> getOrderDetails(Integer userId) {
		List<String> orderDetails= new ArrayList<>();
		List<Order> orderList= findByUserId(userId);
		List<OrderItem> orderItemList;
		String orders="";
		for(Order o : orderList) {
			orders+= "ID order : "+o.getId().toString() +"\n";
			orderItemList = findByOrderId(o.getId());
			for(OrderItem oi : orderItemList) {
				orders+= "Quantità : "+oi.getQuantity().toString() +"\n";
				Optional<Product> p = productRepository.findById(oi.getProductId());
				orders+= p.toString()+"\n";
			}
			orderDetails.add(orders);
			
		}
		
		return orderDetails;
		
		
		
	}

}
