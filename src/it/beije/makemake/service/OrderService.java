package it.beije.makemake.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.makemake.Carrello;
import it.beije.makemake.Order;
import it.beije.makemake.OrderItem;
import it.beije.makemake.Product;
import it.beije.makemake.User;
import it.beije.makemake.repository.OrderRepository;
import it.beije.makemake.repository.ProductRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemService orderItemService;

	@Autowired
	private ProductRepository productRepository;

	public List<Order> findByUserId(Integer userId) {
		return orderRepository.findByUserId(userId);
	}

	public Order save(Order order) {
		return orderRepository.save(order);
	}
	
	
	public Order addOrder(User u, List<Carrello> carrello) {
		double total = 0;
		Order a = new Order();
		a.setDate(LocalDate.now());
		a.setUserId(u.getId());
		a.setStatus("ok");
		save(a);
		
		for (Carrello carrello2 : carrello) {
			
			OrderItem b = new OrderItem();
			b.setOrderId(a.getId());
			b.setQuantity(carrello2.getQta());
			b.setProductId(carrello2.getIdProdotto());
			orderItemService.save(b);
			double price = productRepository.findById(carrello2.getIdProdotto()).getPrice();
			total = total + price * b.getQuantity();
		}
		a = orderRepository.findById(a.getId()).get();
		a.setTotal(total);
		save(a);
		return a;
	}
	public List <Product> prodottiCarrello(List<Carrello> carrello){
		List<Product> prodotti = new ArrayList<>();
		for (Carrello carrello2 : carrello) {
			
			prodotti.add(productRepository.findById(carrello2.getIdProdotto()));
			}
		
		return prodotti;
		
		
	}

}
