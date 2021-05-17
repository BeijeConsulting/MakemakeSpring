package it.beije.makemake.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.makemake.Carrello;
import it.beije.makemake.Contatto;
import it.beije.makemake.Order;
import it.beije.makemake.OrderItem;
import it.beije.makemake.Product;
import it.beije.makemake.User;
import it.beije.makemake.repository.OrderItemRepository;
import it.beije.makemake.repository.OrderRepository;
import it.beije.makemake.repository.ProductRepository;
import it.beije.makemake.service.OrderItemService;
import it.beije.makemake.service.OrderService;
import it.beije.makemake.service.ProductService;
import it.beije.makemake.service.UserService;

@Controller
public class EcommerceController {

	@Autowired
	private UserService userService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderItemService orderItemService;

	@RequestMapping(path = "/login_ecommerce", method = RequestMethod.GET)
	public String user() {

		System.out.println("GET login_ecommerce");

		return "login_ecommerce";
	}

	@RequestMapping(path = "/login_ecommerce", method = RequestMethod.POST)
	public String user(Model model, HttpServletRequest request, @RequestParam(required = false) String username,
			@RequestParam(required = false) String password) {

		HttpSession session = request.getSession();
		System.out.println("POST login_ecommerce");

		try {
			User u = userService.findByUsernameAndPassword(username, password);
			session.setAttribute("loggedUser", u);
			System.out.println(u);
			return "benvenuto";
		} catch (NullPointerException e) {
			model.addAttribute("errore", "Username o password errati");
			return "login_ecommerce";
		}
	}

	@RequestMapping(path = "/visualizza_ordini", method = RequestMethod.GET)
	public String ordini(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("loggedUser");
		
		List<Order> ordini = orderService.findByUserId(u.getId());

		model.addAttribute("ordini", ordini);
		model.addAttribute("numOrdini", ordini.size());

		return "user_order";
		
	}
	@RequestMapping(path = "/visualizza_utente", method = RequestMethod.GET)
	public String utente() {
		return "visualizza_utente";
	}
	
	@RequestMapping(path = "/visualizza_prodotti", method = RequestMethod.GET)
	public String prodotti(Model model) {
		List<Product> prodotti = productRepository.findAll();
		
		model.addAttribute("prodotti", prodotti);

		return "visualizza_prodotti";
	}
	@RequestMapping(path = "/benvenuto", method = RequestMethod.POST)
	public String selezione(@RequestParam String operazione, HttpServletRequest request, Model model) {
		System.out.println("POST benvenuto");
		
		return "benvenuto";
	}

	@RequestMapping(path = "/visualizza_prodotti_ordine", method = RequestMethod.POST)
	public String prodotti(@RequestParam int idOrdine, Model model) {

		System.out.println("POST visualizza_prodotti");
		List<Product> prodotti = productService.findProductsFromOrder(idOrdine);
		model.addAttribute("prodotti", prodotti);
		
		return "visualizza_prodotti_ordine";
	}
	
	@RequestMapping(path = "/aggiungi_al_carrello", method = RequestMethod.POST)
	public String carrello(@RequestParam int quantity,@RequestParam int idProdotto,  HttpServletRequest request,Model model) {
		
		HttpSession session = request.getSession();
		List<Carrello> carrello= null;
		
		if(session.getAttribute("carrello")== null)
			 carrello = new ArrayList<>();
		else
			 carrello = (List<Carrello>) session.getAttribute("carrello");
		
		Carrello c = new Carrello();
		c.setIdProdotto(idProdotto);
		c.setQta(quantity);
		carrello.add(c);
		session.setAttribute("carrello", carrello);
		
		return "carrello";
	}
	
	@RequestMapping(path = "/completa_ordine", method = RequestMethod.GET)
	public String carrello(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
			
		List<Carrello> carrello = (List<Carrello>) session.getAttribute("carrello");
		User u = (User) session.getAttribute("loggedUser");
		
		model.addAttribute("ordine",orderService.addOrder(u,carrello));
		model.addAttribute("prodotti",orderService.prodottiCarrello(carrello));
		
		return "visualizza_carrello";
	}
}
