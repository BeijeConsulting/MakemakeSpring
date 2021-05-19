package it.beije.makemake.service;

import java.util.List;
import java.util.Optional;

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

	public Product getProductById(Integer id) {
		Optional<Product> product = productRepository.findById(id);
		return product.isPresent() ? product.get() : null;
	}

	public void addProductToStock(Product product) {
		Optional<Product> dbProduct = productRepository.findByNameAndBrand(product.getName(), product.getBrand());
		if (!dbProduct.isPresent()) {
			if (product.getId() != null) {
				throw new IllegalArgumentException(
						"I prodotti non ancora presenti nel magazzino non possono avere un ID");
			} else {
				productRepository.save(product);
			}
		} else {
			Product updatingProduct = dbProduct.get();
			updatingProduct.setQuantity(updatingProduct.getQuantity() + product.getQuantity());
			productRepository.save(updatingProduct);
		}
	}

	public void addProductsToStock(List<Product> products) {
		for (Product product : products) {
			addProductToStock(product);
		}
	}
}
