package it.beije.makemake.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import it.beije.makemake.ecommerce.Order;
import it.beije.makemake.ecommerce.OrderItem;
import it.beije.makemake.ecommerce.Product;
import it.beije.makemake.ecommerce.User;
import it.beije.makemake.repository.ProductRepository;
import it.beije.makemake.repository.UserRepository;

@Service
public class ProductService {

	@Autowired
    private ProductRepository productRepository;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderItemService orderItemService;
	
	@Autowired
	private UserService userService;
	
	
	
	public String getProducts(Model model) {
		List<Product> products = productRepository.findAll();
		model.addAttribute("Products", products);
		return "view_products";
	}
	
	public String buyProduct(Model model,Integer id) {
		Optional<Product> productOptional = productRepository.findById(id);
    	if(productOptional.isPresent()) {
    		Product product = productOptional.get();
    		model.addAttribute("product",product);
    		return "buyProduct";
    	}
    	model.addAttribute("error","id of the product not present ");
        return "view_products";
	}

	public String addToCart(Integer productId, Integer amount, HttpSession session, Model model) {
		HashMap<Integer, Integer> cart = (HashMap<Integer, Integer>) session.getAttribute("cart");
		Optional<Product> optionalProduct = productRepository.findById(productId);
		if (cart == null) {
			cart = new HashMap<>();
			session.setAttribute("cart", cart);
		}
		if(optionalProduct.isPresent()) {
			Product product = optionalProduct.get();
			
			if(amount<= product.getCurrentQuantity(cart) ) {
				cart.put(productId, amount);
			}
		}
		
		model.addAttribute("notice", "cart updated");
		return getProducts(model);
	}
	


	@Transactional
	public String sendOrder(HttpSession session, Model model) {
		HashMap<Integer, Integer> cart = (HashMap<Integer, Integer>) session.getAttribute("cart");
		System.out.println(cart);
		BigDecimal total = new BigDecimal(0);
		if (cart == null || cart.isEmpty()) {
			model.addAttribute("error", "Cart is empty");
			return getProducts(model);
		}
		Order order = new Order();
		User user = (User ) session.getAttribute("loggedUser");
		order.setIdUser(user.getId());
		order.setDate(LocalDateTime.now());
		order.setStatus("ok");
		order.setTotal(total);
		orderService.save(order);
		
		Integer orderId = order.getId();
		
		for(Integer productId : cart.keySet()) {
			Optional <Product> productOptional = productRepository.findById(productId);
			if(productOptional.isPresent()) {
				Product product = productOptional.get();
				OrderItem orderItem = new OrderItem() ;
				orderItem.setQuantity(cart.get(productId));
				orderItem.setIdOrder(orderId);
				orderItem.setPrice(product.getPrice());
				orderItem.setProduct(product);
				total = total.add(product.getPrice().multiply(BigDecimal.valueOf(cart.get(productId))));
				product.setQuantity(product.getQuantity()-cart.get(productId));
				productRepository.save(product);
				orderItemService.save(orderItem);
				
			}
		}
		order.setTotal(total);
		orderService.save(order);
		session.removeAttribute("cart");
		model.addAttribute("notice","Order completed with success");
		
	
		return getProducts(model);
	}
	
	
	
	
}
