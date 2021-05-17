package it.beije.makemake.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.mysql.cj.x.protobuf.MysqlxSession.AuthenticateStart;

import it.beije.makemake.Order;
import it.beije.makemake.Product;
import it.beije.makemake.User;
import it.beije.makemake.service.OrderService;
import it.beije.makemake.service.ProductService;


@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private ProductService productService;
	
	@RequestMapping(path = "/vieworder", method = RequestMethod.GET)
	public String getOrder( Model model , SessionStatus status) {
		List<Order> ordini = new ArrayList<Order>();
		ordini =  orderService.getAll();
		model.addAttribute("ordini" , ordini);
		
		return "visualizzazioneOrdine";
	}
	
	@RequestMapping(path = "/createorder", method = RequestMethod.GET)
	public String createOrder (Model model) {
	
		List<Product> prodotti = new ArrayList<Product>();
		prodotti =  productService.getAll();
		model.addAttribute("prodotti" , prodotti);	
		
		System.out.println(prodotti);
	
		return "nuovoOrdine";
	}
	
	@RequestMapping(path = "/createorder", method = RequestMethod.POST)
	public String createOrder (@RequestParam Integer id , Model model, ModelMap modelMap , HttpSession session) {
		
		User user = (User) session.getAttribute("User");
		
	
		
		return "visualizzazioneOrdine";
	}
}
