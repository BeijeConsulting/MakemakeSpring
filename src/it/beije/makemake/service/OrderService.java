package it.beije.makemake.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.makemake.entity.Order;
import it.beije.makemake.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;

	public List<Order> getOrders(Integer userId) {
		if (userId == null) {
			throw new IllegalArgumentException("Id assente");
		}
		return orderRepository.findByUserId(userId);
	}
}
