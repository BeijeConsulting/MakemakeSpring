package it.beije.makemake.ecommerce.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import it.beije.makemake.ecommerce.entity.Order;
import it.beije.makemake.ecommerce.entity.OrderItem;
import it.beije.makemake.ecommerce.entity.User;
import it.beije.makemake.ecommerce.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public String login(String username, String password, Model model, HttpSession session) {
		
		Optional<User> user = userRepository.findByUsername(username);
		
		if(user.isPresent()) {
			User userFromDB = user.get();
			
			if(userFromDB.getUsername().equals(username) &&
					userFromDB.getPassword().equals(password)) {
				model.addAttribute("user", userFromDB);
				return "home";
			}else {
				model.addAttribute("errore", "Username o Password errati");
				return "login";
			}
		}else {
			model.addAttribute("errore", "Username insesistente");
			return "login";
		}
	}
	
	public String viewOrders(User user, Model model) {
		List<Order> orders = user.getOrderlist();
		HashMap<Order, List<OrderItem>> orderMap = new HashMap<Order, List<OrderItem>>();
		
		for(Order o : orders) {
			orderMap.put(o, o.getOrderItemList());
		}
		
		model.addAttribute("orderMap", orderMap);
		
		return "view_orders";
		
	}
}
