package it.beije.makemake.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import it.beije.makemake.repository.OrderRepository;
import it.beije.makemake.repository.ProductRepository;
import it.beije.makemake.service.OrderItemService;
import it.beije.makemake.service.OrderService;
import it.beije.makemake.service.ProductService;
import it.beije.makemake.service.UserService;

@RestController
public class EcommerceRestController {

	@Autowired
	private UserService userService;

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
	
	
}
