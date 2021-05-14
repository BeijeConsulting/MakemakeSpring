//package it.beije.makemake.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import it.beije.makemake.Contatto;
//import it.beije.makemake.repository.ContattoRepository;
//
//
//@Controller
//public class RubricaController {
//	
//	@Autowired
//	private ContattoRepository contattoRepository;
//	
//	
//	@RequestMapping(path = "/vedi_contatto", method = RequestMethod.GET)
//	public String contatto(Model model,
//			@RequestParam(required = false) Integer id,
//			@RequestParam(required = false) String name,
//			@RequestParam(required = false) String email) {
//		
//		System.out.println("GET vedi_contatto : " + id);
//		
//		List<Contatto> contatti = null;
//		if (id != null) {
//			contatti = new ArrayList<Contatto>(1);
//			Optional<Contatto> contatto = contattoRepository.findById(id);
//			if (contatto.isPresent()) contatti.add(contatto.get());
////		} else if (email != null) {
////			contatti = contattoRepository.findByEmail(email);
////		} else if (email != null || name != null) {
////			contatti = contattoRepository.findByNameOrEmail(name, email);
//		} else if (name != null) {
//			contatti = contattoRepository.searchByFirstLettersOfName(name);
//		}
//		
//		model.addAttribute("numContatti", contatti.size());
//		model.addAttribute("contatti", contatti);
//		
//		System.out.println("contatti : " + contatti);
//		
//		return "lista_contatti";
//	}
//
//	@RequestMapping(path = "/inserisci_contatto", method = RequestMethod.GET)
//	public String contatto() {
//		System.out.println("GET inserisci_contatto");
//		
//		return "form_contatto";
//	}
//
//	@Transactional
//	@RequestMapping(path = "/contatto", method = RequestMethod.POST)
//	public String contatto(Contatto contatto, Model model) {
//		System.out.println("POST contatto");
//		
//		System.out.println("contatto : " + contatto);
//		
//		//... eventuali controlli e/o condizioni
//		contattoRepository.save(contatto);
//		
//		model.addAttribute("contatto", contatto);
//		
//		return "vedi_contatto";
//	}
//
//}
