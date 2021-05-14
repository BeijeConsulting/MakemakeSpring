//
//package it.beije.makemake.controller;
//
//import java.util.Locale;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import it.beije.makemake.Contatto;
//
//
//@Controller
//public class TestController {
//	
//	@RequestMapping(path = "/", method = RequestMethod.GET)
//	public String index() {
//		System.out.println("GET index");
//		
//		return "index";
//	}
//
//	@RequestMapping(path = "/test", method = RequestMethod.GET)
//	public String test(HttpServletRequest request, Locale locale, Model model) {
//		System.out.println("GET " + request.getRequestURI() + " " + locale.getDisplayLanguage());
//		
//		model.addAttribute("country", locale.getCountry());
//		model.addAttribute("language", locale.getLanguage());
//		
//		
//		return "test";
//	}
//	
//	@RequestMapping(path = "/login", method = RequestMethod.GET)
//	public String login() {
//		System.out.println("GET login");
//		
//		return "login";
//	}
//
//	@RequestMapping(path = "/login", method = RequestMethod.POST)
//	public String login(@RequestParam String username,
//			@RequestParam(name = "pwd", required = false) String password,
//			@RequestParam int number,
//			Model model) {
//		System.out.println("POST login");
//		
////		String username = request.getParameter("username");
////		String password = request.getParameter("password");
//		System.out.println("username : " + username);
//		System.out.println("password : " + password);
////		int number = Integer.parseInt(request.getParameter("password"));
//		System.out.println("number : " + number);
//		
//		if (username == null || username.length() == 0 || password == null || password.length() == 0) {
//			model.addAttribute("errore", "<h6 style='color:red'>INSERIRE LE CREDENZIALI</h6>");
//			return "login";
//		}
//
//		
//		model.addAttribute("username", username);
//		model.addAttribute("password", password);
//		
//		return "home";
//	}
//
//}
