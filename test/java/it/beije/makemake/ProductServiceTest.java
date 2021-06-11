package it.beije.makemake;

import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import it.beije.makemake.entity.Product;
import it.beije.makemake.service.ProductService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ConfigurationClass.class)
class ProductServiceTest {
	
	Product bomb = new Product();

	@BeforeAll
	void init() {
		bomb.setName("TAG-19");
		bomb.setBrand("Esercito Russo");
		bomb.setDescription("Esplode");
		bomb.setImage("");
		bomb.setPrice(new BigDecimal(13.90));
		bomb.setQuantity(10);
	}

	@Autowired
	private ProductService productService;

	@Test
	void testGetAllProducts() {
		fail("Not yet implemented");
	}

	@Test
	void testGetProductById() {
		fail("Not yet implemented");
	}

	@Test
	void testAddProductToStock() {
		productService.addProductToStock(bomb);
	}

	@Test
	void testAddProductsToStock() {
		fail("Not yet implemented");
	}

}
