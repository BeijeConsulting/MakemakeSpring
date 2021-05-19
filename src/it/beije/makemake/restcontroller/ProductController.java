package it.beije.makemake.restcontroller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.makemake.Product;
import it.beije.makemake.repository.ProductRepository;
import it.beije.makemake.service.ProductService;

@RestController
@RequestMapping("api")
public class ProductController {
	
	@Autowired
	private ProductService ps;
	
	@Autowired
	private ProductRepository pr;

	@GetMapping("/products")
	public @ResponseBody List<Product> getAllProducts(){
		List<Product> products = pr.findAll();
		return products;
	}
	
	@Transactional
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		pr.save(product);
		return product;
	}
}
