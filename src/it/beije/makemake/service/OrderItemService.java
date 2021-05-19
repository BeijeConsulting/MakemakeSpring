package it.beije.makemake.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.makemake.ecommerce.OrderItem;
import it.beije.makemake.repository.OrderItemRepository;

@Service 
public class OrderItemService {

	@Autowired
	private OrderItemRepository orderItemRepository ;
	
	@Transactional
	public void save(OrderItem orderItem) {
		orderItemRepository.save(orderItem);
	}
}
