package it.beije.makemake.controller;

import javax.persistence.PersistenceException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.makemake.entity.User;
import it.beije.makemake.service.UserService;
import it.beije.makemake.util.EcommerceUtil;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String user() {
		return "login";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String user(HttpSession session, Model model, @RequestParam String username, @RequestParam String password) {
		User loggedUser = null;
		try {
			loggedUser = userService.login(username, password);
		} catch (IllegalArgumentException e) {
			model.addAttribute("errore", e.getMessage());
			return "login";
		}
		if (loggedUser == null) {
			model.addAttribute("errore", "Credenziali errate");
			return "login";
		} else {
			session.setAttribute("loggedUser", loggedUser);
			model.addAttribute("displayName", EcommerceUtil.getDisplayName(loggedUser));
			return "homepage";
		}
	}

	@RequestMapping(path = "/registrati", method = RequestMethod.GET)
	public String registrati() {
		return "registrati";
	}

	@RequestMapping(path = "/registrati", method = RequestMethod.POST)
	public String user(HttpSession session, Model model, @RequestParam(required = false) String name,
			@RequestParam(required = false) String surname, @RequestParam String username,
			@RequestParam String password) {
		User loggedUser = null;
		try {
			loggedUser = userService.register(name, surname, username, password);
		} catch (IllegalArgumentException e) {
			model.addAttribute("errore", e.getMessage());
			return "registrati";
		} catch (PersistenceException e) {
			model.addAttribute("errore", e.getMessage());
			return "registrati";
		}
		session.setAttribute("loggedUser", loggedUser);
		model.addAttribute("displayName", EcommerceUtil.getDisplayName(loggedUser));
		return "homepage";
	}

	@RequestMapping(path = "/modifica_utente", method = RequestMethod.GET)
	public String modificaUtente() {
		return "modifica_utente";
	}

	@RequestMapping(path = "/modifica_utente", method = RequestMethod.POST)
	public String modificaUtente(HttpSession session, Model model, @RequestParam(required = false) String name,
			@RequestParam(required = false) String surname, @RequestParam(required = false) String username,
			@RequestParam(required = false) String password) {
		User loggedUser = (User) session.getAttribute("loggedUser");
		try {
			loggedUser = userService.modifyUser(loggedUser, name, surname, username, password);
		} catch (PersistenceException e) {
			model.addAttribute("errore", e.getMessage());
			return "modifica_utente";
		}
		session.setAttribute("loggedUser", loggedUser);
		model.addAttribute("displayName", EcommerceUtil.getDisplayName(loggedUser));
		return "homepage";
	}
	
	@RequestMapping(path="/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
}
