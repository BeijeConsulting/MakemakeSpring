package it.beije.makemake.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import it.beije.makemake.ecommerce.Order;
import it.beije.makemake.ecommerce.User;
import it.beije.makemake.repository.UserRepository;

@Service
public class UserService {
	  @Autowired
	    private UserRepository userRepository;
	
	  public String login(String username, String password, Model model, HttpSession session) {
			if (username != null && password != null) {
	            User user = userRepository.findByUsernameAndPassword(username, password);
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

		public String index(HttpSession session) {
			User user = (User)session.getAttribute("loggedUser");
	        if (user == null) {
	            return "login";
	        } else {
	            return "home";
	        }
		}
		
		public String logout(HttpSession session) {
			session.removeAttribute("loggedUser");
			return "login";
		}
		
		@Transactional
		public String register(User user,Model model) {
			if (user.getUsername() != null && user.getPassword() != null) {
	            User u= userRepository.findByUsername(user.getUsername());
	            if (u == null) {
	               userRepository.save(user);
	               model.addAttribute("notice","User registered succesfully ");
	               return "login";
	            }else {
	            	  model.addAttribute("error", "Username already exist!");
	  	           
	            }
	        } else {
	            model.addAttribute("error", "No credentials where given!"); 
	        }
			
			return "register" ;
		}
		
		public	Optional< User> findById(Integer id) {
			return userRepository.findById(id);
		}
		
		public User findByUsername(String username ) {
			return userRepository.findByUsername(username);
		}
		
		
		
}
