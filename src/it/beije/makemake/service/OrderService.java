package it.beije.makemake.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import it.beije.makemake.ecommerce.Order;
import it.beije.makemake.ecommerce.OrderItem;
import it.beije.makemake.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
    private OrderRepository orderRepository;
  
	public String orderDetails(Integer orderId, Model model) {
		Optional<Order> orderOptional = orderRepository.findById(orderId);
    	if(orderOptional.isPresent()) {
    		List<OrderItem> orderItems = orderOptional.get().getOrderItems();
    		model.addAttribute("orderItems",orderItems);
    		return "order_details";
    	}
    	model.addAttribute("error","id of the order not present ");
        return "orders";
	}

	@Transactional
	public void save(Order order) {
		orderRepository.save(order);
	}

}
