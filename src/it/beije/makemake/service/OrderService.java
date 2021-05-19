package it.beije.makemake.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.beije.makemake.ecommerce.Order;
import it.beije.makemake.ecommerce.OrderDetails;
import it.beije.makemake.ecommerce.OrderItem;
import it.beije.makemake.ecommerce.Product;
import it.beije.makemake.repository.OrderItemRepository;
import it.beije.makemake.repository.OrderRepository;
import it.beije.makemake.repository.ProductRepository;

@Service
public class OrderService {
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	public List<OrderDetails> getOrderDetails(Integer orderId) {

		Optional<Product> p;
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		List<OrderDetails> orderDetails = new ArrayList<OrderDetails>();
		orderItems = orderItemRepository.findByOrderId(orderId);
		for (int i = 0; i < orderItems.size(); i++) {
			OrderDetails orderD = new OrderDetails();
			p = productRepository.findById(orderItems.get(i).getProductId());
			orderD.setName(p.get().getName());
			orderD.setBrand(p.get().getBrand());
			orderD.setDescription(p.get().getDesc());
			orderD.setOrderItemQuantity(orderItems.get(i).getQuantity());
			orderD.setPrice(orderItems.get(i).getPrice());

			orderDetails.add(orderD);
		}
		System.out.println(orderDetails);
		return orderDetails;
	}
	
	public List<Order> findByUserId(Integer userId) {
		return orderRepository.findByUserId(userId);
	}
	
	public List<Order> showOrder() {
		return orderRepository.findAll();
	}

}
