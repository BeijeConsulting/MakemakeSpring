package it.beije.makemake.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.makemake.ecommerce.genericsclasses.Product;
import it.beije.makemake.repository.ProductRepository;


@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	@RequestMapping(path = "/vedi_prodotto", method = RequestMethod.GET)
	public String contatto(Model model,
			@RequestParam(required = false) Integer id,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String brand,
			@RequestParam(required = false) String descr,
			@RequestParam(required = false) Double price,
			@RequestParam(required = false) Integer quantity) {
		
		System.out.println("GET vedi_prodotto : " + id);
		
		List<Product> prodotti = null;
		if (id != null) {
			prodotti = new ArrayList<Product>(1);
			Optional<Product> prodotto = productRepository.findById(id);
			if (prodotto.isPresent()) prodotti.add(prodotto.get());
		} else if (name != null) {
			prodotti = productRepository.searchByFirstLettersOfName(name);
		}
		
		model.addAttribute("numProdotti", prodotti.size());
		model.addAttribute("prodotti", prodotti);
		
		System.out.println("prodotti : " + prodotti);
		
		return "lista_prodotti";
	}
}
