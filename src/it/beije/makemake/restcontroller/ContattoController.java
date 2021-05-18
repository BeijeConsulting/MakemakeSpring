package it.beije.makemake.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.makemake.Contatto;
import it.beije.makemake.repository.ContattoRepository;
import it.beije.makemake.service.ContattoService;


@RestController
@RequestMapping("api")
public class ContattoController {

	@Autowired
	private ContattoService contattoService;

	@Autowired
	private ContattoRepository contattoRepository;

	
//	@RequestMapping(path = "/contatto", method = RequestMethod.GET)
//	public @ResponseBody Contatto contatto(@RequestParam Integer id) {
	@GetMapping("/contatto/{id}")
	public @ResponseBody Contatto getContatto(@PathVariable(name = "id") Integer id) {
		
		System.out.println("GET getContatto : " + id);
		
		Contatto contatto = contattoService.findById(id);
		
		System.out.println("contatto : " + contatto);
		
		return contatto;
	}

	@GetMapping("/contatti")
	public @ResponseBody List<Contatto> getContatti() {
		
		System.out.println("GET getContatti");
		
		List<Contatto> contatti = contattoRepository.findAll();
		
		System.out.println("contatti : " + contatti.size());
		
		return contatti;
	}
	
	@Transactional
	//@RequestMapping(path = "/contatto", method = RequestMethod.POST)
	@PostMapping("/contatto")
	public Contatto insertContatto(@RequestBody Contatto contatto) {
		System.out.println("POST contatto");
		
		System.out.println("contatto : " + contatto);
		
		contattoService.save(contatto);
		
		return contatto;
	}
	
	@Transactional
	@PutMapping("/contatto/{id}")
	public @ResponseBody Contatto updateContatto(@PathVariable(name = "id") Integer id, @RequestBody Contatto newData) {
		
		System.out.println("PUT updateContatto : " + id);

		
		Contatto contatto = contattoService.findById(id);
		
		contatto.setName(newData.getName());
		contatto.setSurname(newData.getSurname());
		contatto.setTelephone(newData.getTelephone());
		contatto.setEmail(newData.getEmail());
		
		contattoService.save(contatto);		
		System.out.println("contatto : " + contatto);
		
		return contatto;
	}
	
	@DeleteMapping("/contatto/{id}")
	public @ResponseBody Map<String, String> deleteContatto(@PathVariable(name = "id") Integer id) {
		
		System.out.println("DELETE deleteContatto : " + id);
		
		contattoRepository.deleteById(id);
		
		HashMap<String, String> response = new HashMap<String, String>();
		
		response.put("message", "contatto cancellato");
		
		return response;
	}
	
	@GetMapping("/cercacontatto/{name}")
	public @ResponseBody List<Contatto> searchContatto(@PathVariable(name = "name") String name) {
		
		System.out.println("GET searchContatto : " + name);
		
		List<Contatto> contatti= contattoService.findByName(name);
		
		System.out.println("contatto : " + contatti);
		
		return contatti;
	}
	
	

}
