package it.beije.makemake.ecommerce.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import it.beije.makemake.ecommerce.entity.Product;
import it.beije.makemake.ecommerce.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public String getProducts(Model model) {
		
		List<Product> lista = productRepository.findAll();
		if(!(lista.isEmpty())){
			model.addAttribute("products", lista);
		}else {
			model.addAttribute("errore","Nessun prodotto disponibile");
		}
		return "view_products";
	}
	
}
