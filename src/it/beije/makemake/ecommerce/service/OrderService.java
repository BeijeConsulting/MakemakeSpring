package it.beije.makemake.ecommerce.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.makemake.ecommerce.entity.*;
import it.beije.makemake.ecommerce.repository.OrderItemRepository;
import it.beije.makemake.ecommerce.repository.OrderRepository;
import it.beije.makemake.ecommerce.repository.ProductRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private  ProductRepository productRepository;
	@Autowired
	private OrderItemRepository itemRepository;
	
	public Order doOrder(List<OrderItem> lista, Integer userId) {
		Double total = 0.00;
		for (OrderItem orderItem : lista) {
		
			Optional <Product> prodotto = (orderItem.getProductId() != null)? 
												productRepository.findById(orderItem.getProductId()) :
												null;
			if(prodotto != null && prodotto.isPresent()) {
				if(prodotto.get().getQuantity() < orderItem.getQuantity()) {
					return null;
				}else {
					total+=  orderItem.getPrice()*orderItem.getQuantity();
				}
				
			}else {
				return null;
			}
			
	   }
		Order comodo = saveOrder(userId, total);
		if(comodo != null) {
			for (OrderItem orderItem : lista) {
				orderItem.setOrderId(comodo.getId());
				itemRepository.save(orderItem);
			}
		}	
		return comodo;
	}
	
	public Order saveOrder(Integer userId, Double total) {
		LocalDateTime ora = LocalDateTime.now();
		
		Order comodo = new Order();
		comodo.setDate(ora);
		comodo.setUserID(userId);
		comodo.setStatus("ok");
		comodo.setTotal(total);
		orderRepository.save(comodo);
		
		System.out.println(comodo);
		return comodo;
	}
}
