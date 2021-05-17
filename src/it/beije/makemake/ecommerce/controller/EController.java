package it.beije.makemake.ecommerce.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.makemake.ecommerce.entity.User;
import it.beije.makemake.ecommerce.service.OrderItemService;
import it.beije.makemake.ecommerce.service.ProductService;
import it.beije.makemake.ecommerce.service.UserService;

@Controller
public class EController {
	
	@Autowired
	private UserService userService ;
	
	@Autowired
	private ProductService productService ;
	
	@Autowired
	private OrderItemService orderItemService;
	
	@RequestMapping(path = "/welcome_page", method = RequestMethod.GET)
	public String getWelcomePage() {
		return "welcome";
	}
	@RequestMapping(path = "/login_page", method = RequestMethod.GET)
	public String getLogin() {
		return "login";
	}
	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String login(@RequestParam(required = true) String username, @RequestParam(required = true) String pwd, Model model , HttpSession session) {	
		return userService.login(username, pwd, model, session);
	}
	@RequestMapping(path = "/product_page", method = RequestMethod.GET)
	public String getProductPage(Model model ) {
		return productService.getProducts(model);
	}
	@RequestMapping(path = "/order_page", method = RequestMethod.GET)
	public String getOrderPage(Model model, HttpSession session) {
		User comodo = (User) session.getAttribute("user");
		if(comodo !=null) {
			return userService.getOrderList(comodo, model);
		}
		return "login";
	}
	
	@RequestMapping(path = "/order_details_page", method = RequestMethod.GET)
	public String getOrderDetailsPage(@RequestParam Integer orderId, Model model) {
		return orderItemService.getOrderItems(orderId, model);
	}
	
	@RequestMapping(path = "/logout_page", method = RequestMethod.GET)
	public String getLogoutPage() {
		return "welcome";
	}
}
