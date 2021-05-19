package it.beije.makemake.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.makemake.entity.Product;
import it.beije.makemake.service.ProductService;

@RestController
@RequestMapping("api")
public class ProductRestController {

	@Autowired
	private ProductService productService;

	@GetMapping("/prodotto/{id}")
	public @ResponseBody Product getProduct(@PathVariable(name = "id") Integer id) {
		Product product = productService.getProductById(id);
		// TODO if(product==null){}
		return product;
	}

	@GetMapping("/prodotti")
	public @ResponseBody List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@Transactional
	@PutMapping("/aggiungi_prodotto")
	public @ResponseBody void addProduct(@RequestBody Product product) {
		productService.addProductToStock(product);
	}

	@Transactional
	@PutMapping("/aggiungi_prodotti")
	public @ResponseBody void addProducts(@RequestBody List<Product> products) {
		productService.addProductsToStock(products);
	}
}
