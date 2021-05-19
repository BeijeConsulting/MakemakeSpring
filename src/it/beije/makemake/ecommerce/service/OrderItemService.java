package it.beije.makemake.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import it.beije.makemake.ecommerce.entity.Order;
import it.beije.makemake.ecommerce.entity.OrderItem;
import it.beije.makemake.ecommerce.repository.OrderItemRepository;
import it.beije.makemake.ecommerce.repository.OrderRepository;

@Service
public class OrderItemService {
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	public String getOrderItems(Integer orderId, Model model) {
		List<OrderItem> items = orderItemRepository.findByOrderId(orderId);
		if(!(items.isEmpty())){
			model.addAttribute("items", items);
		}else {
			model.addAttribute("errore","Dettaglio ordine vuoto");
		}
		return "view_details_order";
	}
	
}
