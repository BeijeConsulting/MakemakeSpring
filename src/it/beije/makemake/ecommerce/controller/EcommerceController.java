//package it.beije.makemake.ecommerce.controller;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import it.beije.makemake.ecommerce.service.UserService;
///*
//
//<li><a href="login.jsp">Fai il login</a></li>
//<li><a href="registration.jsp">Registrati</a>
//<li><a href="showproducts">Visualizza prodotti disponibili</a></li>
//<li><a href="chooseproduct">Aggiungi al carrello</a></li>
//<li><a href="cart">Vai al carrello</a>
//<li><a href="showorders">Dettaglio oridini</a></li>
//<li><a href="logout.jsp">Fai logout</a></li>
//
// */
//
//@Controller
//public class EcommerceController {
//
//	@Autowired
//	private UserService userService;
//	
//	//pagina di scelta o se si sbaglia l'url
//	@RequestMapping(path="/welcome", method=RequestMethod.GET)
//	public String welcome() {
//		return "welcome";
//	}
//	
//	@RequestMapping(path="/login", method=RequestMethod.POST)
//	public String login(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
//		return userService.login(username, password, model, session);
//	}
//	
//	@RequestMapping(path="/login_page", method=RequestMethod.GET)
//	public String login() {
//		return "login";
//	}
//	
//	@RequestMapping(path="/login/view_orders")
//	public String viewOrders(Model model) {
//		User logged = model.getAttribute("user");
//		
//		if(user == null) {
//			model.addAttribute("errore", "Devi essere loggato per poter vedere gli ordini effettuati");
//			return "login_page";
//		}else {
//			userService.viewOrders(user);
//		}
//	}
//	
//}
