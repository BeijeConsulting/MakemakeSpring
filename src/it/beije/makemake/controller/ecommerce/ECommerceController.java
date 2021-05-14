package it.beije.makemake.controller.ecommerce;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.makemake.ecommerce.User;
import it.beije.makemake.service.OrderService;
import it.beije.makemake.service.UserService;

@Controller
public class ECommerceController {


    @Autowired
    private UserService userService;

    
    @Autowired
    private OrderService orderService;
  


    @RequestMapping(path="/ecommerce/")
    public String index(HttpSession session) {
        return userService.index(session);
    }



    @RequestMapping(path="/ecommerce/login", method = RequestMethod.POST)
    public String login(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        return userService.login(username, password, model, session);
    }

	

    @RequestMapping(path="/ecommerce/orders")
    public String viewOrders(HttpSession session, Model model) {
        return userService.viewOrders(session, model);
    }

	
    @RequestMapping(path="ecommerce/order_details", method=RequestMethod.GET)
    public String orderDetails(@RequestParam Integer orderId,Model model) {
    	return orderService.orderDetails(orderId, model);
    }
    
    @RequestMapping(path="/ecommerce/logout")
    public String logout(HttpSession session) {
    	return userService.logout(session);
    }

    @Transactional
    @RequestMapping(path = "ecommerce/register",method = RequestMethod.POST)
    public String register(User user , Model model) {
    	return userService.register(user, model);
    }
	
    @RequestMapping(path = "ecommerce/registration")
    public String register() {
    	return "register";
    }
    

}
