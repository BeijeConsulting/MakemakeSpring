package it.beije.makemake.ecommerce.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import it.beije.makemake.ecommerce.entity.Order;
import it.beije.makemake.ecommerce.entity.User;
import it.beije.makemake.ecommerce.repository.UserRepository;


@Service
public class UserService {
	@Autowired
	private UserRepository  userRepository;
	
	public String login(String username, String password, Model model, HttpSession session) {
	Optional<User> user=userRepository.findByUsernameAndPassword(username, password);
	if(user.isPresent()) {
		session.setAttribute("user", user.get());
		return "home";
	}else
		model.addAttribute("errore", "Credenziali errate.");
		return "login";
	}
	
	public String getOrderList(User user,Model model) {
			
		List<Order> lista= user.getOrders();
		if(!(lista.isEmpty())){
			model.addAttribute("orders", lista);
		}else {
			model.addAttribute("errore","Nessun ordine effetuato");
		}
		return "view_orders";
	}
}
