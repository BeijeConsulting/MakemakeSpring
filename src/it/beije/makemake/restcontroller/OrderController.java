package it.beije.makemake.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.makemake.Order;
import it.beije.makemake.repository.OrderRepository;


@RestController
@RequestMapping("api")
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;

	
	@GetMapping("/orders")
	public List<Order> getOrders() {
		System.out.println("GET /orders");
		
		return orderRepository.findAll();
	}
}
