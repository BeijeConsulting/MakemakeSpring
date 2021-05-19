package it.beije.makemake.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.makemake.ecommerce.Product;
import it.beije.makemake.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> showProduct() {
		return productRepository.findAll();
	}

	public List<Product> findByName(String name) {
		return productRepository.findByName(name);
	}

}
