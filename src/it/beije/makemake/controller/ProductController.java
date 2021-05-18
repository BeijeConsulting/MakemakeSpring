package it.beije.makemake.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	
	@RequestMapping(path = "/mostra_prodotti", method = RequestMethod.POST)
	public String mostraProdotti() {
		return "redirect:dettaglio_prodotto";
	}

	@RequestMapping(path = "/dettaglio_prodotto", method = RequestMethod.GET)
	public String dettaglioProdotto(HttpServletRequest request, Model model) {
		// TODO gestire il path non come dettaglio_prodotto, ma come
		// dettaglio_prodotto?id=XX
		Product product = productService.getProductById((Integer) request.getAttribute("id"));
		model.addAttribute("prodotto", product);
		return "dettaglio_prodotto";
	}
}
