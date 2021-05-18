//package it.beije.makemake.service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import it.beije.makemake.Contatto;
//import it.beije.makemake.repository.ContattoRepository;
//
//
//@Service
//public class ContattoService {
//	
//	@Autowired
//	private ContattoRepository contattoRepository;
//
//	
//	public Contatto findById(Integer id) {
//		Optional<Contatto> contatto = contattoRepository.findById(id);
//		return contatto.isPresent() ? contatto.get() : null;
// 	}
//	
//	public List<Contatto> searchContatti(Integer id, String name, String email) {
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
//		return contatti;
//	}
//	
//	public Contatto save(Contatto contatto) {
//		return contattoRepository.save(contatto);
//	}
//
//	public List<Contatto> findByEmail(String email) throws Exception {
//		if (email != null && email.length() > 0 ) { //& email.contains('@') or regular expression for email patterns
//			return contattoRepository.findByEmail(email);
//		} else {
//			throw new Exception("Email non corretta!!!");
//			// oppure return null;
//		}
//	}
//
//	public List<Contatto> findByNameOrEmail(String name, String email) {
//		return contattoRepository.findByNameOrEmail(name, email);
//	}
//
//}
