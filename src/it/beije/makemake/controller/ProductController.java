package it.beije.makemake.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.makemake.entity.Product;
import it.beije.makemake.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;

	@RequestMapping(path = "/mostra_prodotti", method = RequestMethod.GET)
	public String mostraProdotti(Model model) {
		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		return "mostra_prodotti";
	}
}

