package it.beije.makemake;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import it.beije.makemake.service.ProductService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ConfigurationClass.class)
class ProductRestControllerTest {

	@Autowired
	private ProductService productService;

	@Test
	void testGetProduct() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllProducts() {
		fail("Not yet implemented");
	}

	@Test
	void testAddProduct() {
		fail("Not yet implemented");
	}

	@Test
	void testAddProducts() {
		fail("Not yet implemented");
	}

}
