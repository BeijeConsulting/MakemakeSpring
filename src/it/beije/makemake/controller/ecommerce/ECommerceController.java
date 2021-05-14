package it.beije.makemake.controller.ecommerce;

import it.beije.makemake.ecommerce.Order;
import it.beije.makemake.ecommerce.User;
import it.beije.makemake.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ECommerceController {

    @Autowired
    private UserRepository userRepository;


    @RequestMapping(path="/ecommerce/")
    public String index(HttpSession session) {
        User user = (User)session.getAttribute("loggedUser");
        if (user == null) {
            return "login";
        } else {
            return "home";
        }
    }

    @RequestMapping(path="/ecommerce/login", method = RequestMethod.POST)
    public String login(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        if (username != null && password != null) {
            User user = userRepository.findByUsernameOrPassword(username, password);
            if (user == null) {
                model.addAttribute("error", "Check your username or password");
                return "login";
            }
            session.setAttribute("loggedUser", user);
            model.addAttribute("user", user);
            return "home";
        } else {
            model.addAttribute("error", "No credentials where given!");
            return "login";
        }
    }

    @RequestMapping(path="/ecommerce/orders")
    public String viewOrders(HttpSession session, Model model) {
        User user = (User)session.getAttribute("loggedUser");
        if (user != null) {
            List<Order> orders = user.getOrders();
            model.addAttribute("orders", orders);
            return "orders";
        }
        model.addAttribute("error", "Session has timed out");
        return "login";
    }

    @RequestMapping(path="ecommerce/order_details", method=RequestMethod.GET)
    public String orderDetails() {
        return "";
    }

}
