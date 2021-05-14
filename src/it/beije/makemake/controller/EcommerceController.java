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
import it.beije.makemake.Order;
import it.beije.makemake.User;
import it.beije.makemake.service.OrderService;
import it.beije.makemake.service.UserService;

@Controller
public class EcommerceController {


	@Autowired
	private UserService userService;
	@Autowired
	private OrderService orderService;

	
	
	@RequestMapping(path = "/login_ecommerce", method = RequestMethod.GET)
	public String user() {

		System.out.println("GET login_ecommerce");

		return "login_ecommerce";
	}

	@RequestMapping(path = "/login_ecommerce", method = RequestMethod.POST)
	public String user(Model model,HttpServletRequest request, 
			@RequestParam(required = false) String username,
			@RequestParam(required = false) String password) {
		
		HttpSession session = request.getSession();
		System.out.println("POST login_ecommerce");
		
		try {
			User u = userService.findByUsernameAndPassword(username,password);
			session.setAttribute("loggedUser", u);
			System.out.println(u);
			return "benvenuto";
		} catch (NullPointerException e) {
			model.addAttribute("errore", "Username o password errati");
			return "login_ecommerce";
		}
	}
	
	@RequestMapping(path = "/benvenuto", method = RequestMethod.GET)
	public String selezione() {
		System.out.println("GET benvenuto");

		return "benvenuto";
	}
	
	@RequestMapping(path = "/benvenuto", method = RequestMethod.POST)
	public String selezione(@RequestParam String operazione, HttpServletRequest request,Model model) {
		System.out.println("POST benvenuto");
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("loggedUser");
		
		switch (operazione) {
		case "visualizza_ordini":
			List<Order> ordini = orderService.findByUserId(u.getId());
			
			model.addAttribute("ordini", ordini);
			model.addAttribute("numOrdini", ordini.size());
			
			return "user_order";
		}

		return "benvenuto";
	}


}
