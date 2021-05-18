package it.beije.makemake.restcontroller.ecommerce;

import it.beije.makemake.ecommerce.Order;
import it.beije.makemake.ecommerce.User;
import it.beije.makemake.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("ecommerce/api/")
public class ECommerceRestController {

    @Autowired
    UserRepository userRepository;


    @GetMapping("orders/{id}")
    public @ResponseBody List<Order> getOrders(@PathVariable Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        List<Order> orders = null;

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            orders = user.getOrders();
        }
        return orders;
    }

    @GetMapping("user/{id}")
    public @ResponseBody User getUser(@PathVariable Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    @PostMapping("register")
    public @ResponseBody User register(@RequestBody User user) {
        if (user != null) {
            User check = userRepository.findByUsername(user.getUsername());
            if (check == null)
                userRepository.save(user);
            else
                user = check;
        }
        return user;
    }
}
