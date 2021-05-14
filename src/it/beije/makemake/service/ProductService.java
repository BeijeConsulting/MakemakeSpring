package it.beije.makemake.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import it.beije.makemake.ecommerce.Order;
import it.beije.makemake.ecommerce.OrderItem;
import it.beije.makemake.ecommerce.Product;
import it.beije.makemake.repository.ProductRepository;

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
}
