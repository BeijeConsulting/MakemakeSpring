package it.beije.makemake.ecommerce.service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.makemake.ecommerce.entity.Order;
import it.beije.makemake.ecommerce.entity.OrderItem;
import it.beije.makemake.ecommerce.entity.Product;
import it.beije.makemake.ecommerce.repository.OrderItemRepository;
import it.beije.makemake.ecommerce.repository.OrderRepository;
import it.beije.makemake.ecommerce.repository.ProductRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public Order insertOrder(List<OrderItem> newData, Integer userId) {
		double total = 0;
		
		for(OrderItem item : newData) {
			Optional<Product> product = item.getProductId()!=null ? productRepository.findById(item.getProductId()):null;
			
			if(product != null && product.isPresent()) {
				if(product.get().getQuantity() >= item.getQuantity()) {
					total += item.getPrice()*item.getQuantity();
					continue;
				}else {
					return null;
				}
			}else {
				return null;
			}
			
		}
		
		//if all orderItems are valid i can set the order
		Order saved = saveOrder(total, userId);
		
		if(saved != null) {
			for(OrderItem item :  newData) {
				item.setOrderId(saved.getId());
				orderItemRepository.save(item);
			}
		}
		
		return saved;
	
		
		
		

		
	}
	
	@Transactional
	private Order saveOrder(Double total, Integer userId){
		LocalDateTime orderDate =LocalDateTime.now();
		
		Order order = new Order();
		order.setStatus("OK");
		order.setDate(orderDate);
		order.setTotal(total);
		order.setUserID(userId);
		
		orderRepository.save(order);
		
	
		return order;
		
		
		
	}

}
