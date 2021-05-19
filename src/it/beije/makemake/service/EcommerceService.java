package it.beije.makemake.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.beije.makemake.ecommerce.Order;
import it.beije.makemake.ecommerce.OrderItem;
import it.beije.makemake.ecommerce.User;
import it.beije.makemake.repository.OrderItemRepository;
import it.beije.makemake.repository.OrderRepository;
import it.beije.makemake.repository.UserRepository;

@Service
public class EcommerceService {

	@Autowired
	private UserRepository userRepository;

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



	public List<OrderItem> showOrderItem() {
		return orderItemRepository.findAll();
	}

	public User findByUsernameAndPassword(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}



	public List<OrderItem> findByOrderId(Integer orderId) {
		return orderItemRepository.findByOrderId(orderId);
	}

	
}
