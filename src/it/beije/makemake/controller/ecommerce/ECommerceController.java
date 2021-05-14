package it.beije.makemake.controller.ecommerce;

import it.beije.makemake.ecommerce.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class ECommerceController {


    @RequestMapping(path="/ecommerce/")
    public String index(HttpSession session) {
        User user = (User)session.getAttribute("loggedUser");
        if (user.getName() == null) {
            return "login";
        } else {
            return "home";
        }
    }

    @RequestMapping(path="ecommerce/login")
    public String login(@RequestParam String username, @RequestParam String password) {

    }

}
