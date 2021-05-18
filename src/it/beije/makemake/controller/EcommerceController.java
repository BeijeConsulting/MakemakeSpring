package it.beije.makemake.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.makemake.ecommerce.Product;
import it.beije.makemake.ecommerce.User;
import it.beije.makemake.service.EcommerceService;

@Controller
public class EcommerceController {

	@Autowired
	private EcommerceService ecommerceService;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String index() {
		System.out.println("GET index");

		return "login_ecommerce";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String homepage(Model model, HttpServletRequest request, @RequestParam(required = false) String username,
			@RequestParam(required = false) String password) {
		User user = ecommerceService.findByUsernameAndPassword(username, password);

		if (username == null || username.length() == 0 || password == null || password.length() == 0) {
			model.addAttribute("errore", "<h6 style='color:red'>INSERIRE LE CREDENZIALI</h6>");
			return "login_ecommerce";
		}
		if (user == null) {
			model.addAttribute("errore", "<h6 style='color:red'> CREDENZIALI ERRATE</h6>");
			return "login_ecommerce";
		}

		request.getSession().setAttribute("user", user);
		System.out.println("POST homepage");
		System.out.println("GET user : " + user);
		return "homepage";
	}

	@RequestMapping(path = "/registrazione", method = RequestMethod.GET)
	public String registrazione() {
		System.out.println("GET registrazone");

		return "registrazione";
	}

	@RequestMapping(path = "/registrazione", method = RequestMethod.POST)
	public String registrazione(Model model, 
			@RequestParam(required = false) String username,
			@RequestParam(required = false) String password,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String surname) {
		if (username == null || username.length() == 0 || 
				password == null || password.length() == 0 ||
				name == null || name.length() == 0 ||
				surname == null || surname.length() == 0) {
			model.addAttribute("errore", "<h6 style='color:red'>DATI NON VALIDI</h6>");
			return "registrazione";
		}
		System.out.println("GET registrazone");
		ecommerceService.save(username, name, surname, password);
		return "login_ecommerce";
	}

	@RequestMapping(path = "/visualizza_prodotti", method = RequestMethod.GET)
	public String visualizza_prodotti(HttpServletRequest request) {
		System.out.println("GET visualizza_prodotti");
		request.getSession().setAttribute("prodotti", ecommerceService.showProduct());
		return "visualizza_prodotti";
	}

	@RequestMapping(path = "/homepage", method = RequestMethod.GET)
	public String home() {
		System.out.println("GET homepage");

		return "homepage";
	}

	@RequestMapping(path = "/ricerca_prodotto", method = RequestMethod.GET)
	public String ricerca_prodotto(Model model,
			@RequestParam String name) {
		List<Product> productList = ecommerceService.findByName(name);
		System.out.println("POST ricerca_prodotto");
		System.out.println(productList);
		
		if (productList.size()==0 ||productList==null) {
			model.addAttribute("errore", "<h6 style='color:red'> NESSUN PRODOTTO TROVATO</h6>");
			System.out.println("errore");
		}
		model.addAttribute("lista_prodotti", productList);
		return "ricerca_prodotto";
	}


	@RequestMapping(path = "/ricerca_prodotto", method = RequestMethod.POST)
	public String ricerca_prodotto() {
		System.out.println("GET ricerca_prodotto");
		return "ricerca_prodotto";
	}
	
	@RequestMapping(path = "/visualizza_ordini", method = RequestMethod.GET)
	public String visualizza_ordini(HttpServletRequest request) {
		System.out.println("GET visualizza_ordini");
		User user=(User)request.getSession().getAttribute("user");
		Integer userId = user.getId();
		request.getSession().setAttribute("dettaglio_ordine", ecommerceService.getOrderDetails(userId));
		
		return "visualizza_ordini";
	}
	
	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		System.out.println("GET login_ecommerce");
		request.getSession().invalidate();
		return "login_ecommerce";
	}
}
