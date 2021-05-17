package it.beije.makemake.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.makemake.OrderItem;
import it.beije.makemake.repository.OrderItemRepository;

@Service
public class OrderItemService {
	@Autowired
	private OrderItemRepository orderItemRepository;

	public OrderItem save(OrderItem orderItem) {
		return orderItemRepository.save(orderItem);
	}
}
