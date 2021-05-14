package it.beije.makemake.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.makemake.Product;
import it.beije.makemake.service.ProductService;
import it.beije.makemake.service.UserService;

@Controller
public class ProductContoller {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(path = "/viewproduct", method = RequestMethod.GET)
	public String getProducts ( Model model) {
		
		List<Product> prodotti = new ArrayList<Product>();
		prodotti =  productService.getAll();
		model.addAttribute("prodotti" , prodotti);	
		
	return "visualizzazioneProdotti";
	
	}
	
}
