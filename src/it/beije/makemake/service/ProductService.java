package it.beije.makemake.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import it.beije.makemake.ecommerce.Order;
import it.beije.makemake.ecommerce.OrderItem;
import it.beije.makemake.ecommerce.Product;
import it.beije.makemake.repository.ProductRepository;

import javax.servlet.http.HttpSession;

@Service
public class ProductService {

	@Autowired
    private ProductRepository productRepository;
	
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
		if (cart == null) {
			cart = new HashMap<>();
		}
		cart.put(productId, amount);
		model.addAttribute("notice", "cart updated");
		return getProducts(model);
	}

	public String sendOrder(HttpSession session, Model model) {
		HashMap<Integer, Integer> cart = (HashMap<Integer, Integer>) session.getAttribute("cart");
		if (cart == null) {
			model.addAttribute("error", "Cart is empty");
			return getProducts(model);
		}
		Order order =
		return null;
	}
}
