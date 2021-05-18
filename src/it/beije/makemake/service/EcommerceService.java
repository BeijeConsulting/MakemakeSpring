package it.beije.makemake.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import it.beije.makemake.Contatto;
import it.beije.makemake.ecommerce.EcommerceManager;
import it.beije.makemake.ecommerce.Order;
import it.beije.makemake.ecommerce.OrderDetails;
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

	public List<OrderItem> findByOrderId(Integer orderId) {
		return orderItemRepository.findByOrderId(orderId);
	}

	public void getOrderDetails(Integer userId,List<OrderDetails> orderDetails) {
		OrderDetails orderD = new OrderDetails();
		List<Order> orderList = findByUserId(userId);
		List<OrderItem> orderItemList;
		for (int i = 0; i < orderList.size(); i++) {
			orderD.setOrderId(orderList.get(i).getId());
			orderItemList = findByOrderId(orderList.get(i).getId());
			for (OrderItem oi : orderItemList) {
				Optional<Product> p = productRepository.findById(oi.getProductId());
				orderD.setName( p.get().getName());
				orderD.setBrand(p.get().getBrand());
				orderD.setDescription(p.get().getDesc());
				orderD.setOrderItemQuantity(oi.getQuantity());
			}
			orderDetails.add(orderD);
			System.out.println(orderD);
		}
	}

}
