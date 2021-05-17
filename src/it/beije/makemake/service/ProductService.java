package it.beije.makemake.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.makemake.OrderItem;
import it.beije.makemake.Product;
import it.beije.makemake.repository.OrderItemRepository;
import it.beije.makemake.repository.OrderRepository;
import it.beije.makemake.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired 
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findProductsFromOrder(int idOrdine){
		
		List<OrderItem> idprodotti =  orderItemRepository.findByOrderId(idOrdine);
		List<Product> prodotti = new ArrayList<Product>();
		
		for (OrderItem orderItem : idprodotti) {
			prodotti.add(productRepository.findById(orderItem.getProductId()).get());
			
		}
		return prodotti;
	}
}
