package it.beije.makemake.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.makemake.entity.Product;
import it.beije.makemake.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public void save(Product prodotto) {
		// TODO Auto-generated method stub
		productRepository.save(prodotto);
	}
	
	public List<Product> addToCar(List<Product> carrello, Product prodotto) {
		carrello.add(prodotto);
		return carrello;
	}
}
