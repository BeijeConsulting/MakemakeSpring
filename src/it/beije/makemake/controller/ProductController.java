package it.beije.makemake.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.makemake.entity.Product;
import it.beije.makemake.User;
import it.beije.makemake.service.ProductService;
import it.beije.makemake.util.EcommerceUtil;

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

	@RequestMapping(path = "/dettaglio_prodotto", method = RequestMethod.GET)
	public String dettaglioProdotto(Model model) {
		// TODO gestire il path non come dettaglio_prodotto, ma come
		// dettaglio_prodotto?id=XX
		return "dettaglio_prodotto";
	}
	
	@RequestMapping(path = "/aggiungi", method = RequestMethod.POST)
	public String user(HttpSession session, Model model, @RequestParam String username, @RequestParam String password) {
		User loggedUser = null;
		try {
			loggedUser = userService.login(username, password);
		} catch (IllegalArgumentException e) {
			model.addAttribute("errore", e.getMessage());
			return "login";
		}
		if (loggedUser == null) {
			model.addAttribute("errore", "Credenziali errate");
			return "login";
		} else {
			session.setAttribute("loggedUser", loggedUser);
			model.addAttribute("displayName", EcommerceUtil.getDisplayName(loggedUser));
			return "homepage";
		}
	}

}

