package it.beije.makemake.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.makemake.Order;
import it.beije.makemake.User;
import it.beije.makemake.repository.OrderRepository;
import it.beije.makemake.repository.UserRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	public List<Order> findByUserId(Integer userId) {
		return orderRepository.findByUserId(userId);
	}
}
