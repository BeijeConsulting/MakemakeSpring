package it.beije.makemake.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.makemake.Contatto;
import it.beije.makemake.entity.Product;
import it.beije.makemake.repository.ProductRepository;
import it.beije.makemake.service.ProductService;

@RestController
@RequestMapping("api")
public class ProductRestControl {

	@Autowired
	private ProductService prodottoService;

	@Autowired
	private ProductRepository prodottoRepository;

	@GetMapping("/prodotti")
	public @ResponseBody List<Product> getProdotti() {
		
		System.out.println("GET getProdotti");
		
		List<Product> prodotti = prodottoRepository.findAll();
		
		System.out.println("prodotti : " + prodotti.size());
		
		return prodotti;
	}
	
	@Transactional
	@PostMapping("/prodotto")
	public Product insertProdotto(@RequestBody Product prodotto) {
		System.out.println("POST prodotto");
		
		System.out.println("prodotto : " + prodotto);
		
		prodottoService.save(prodotto);
		
		return prodotto;
	}
	
	@PostMapping("/aggiungi")
	public List<Product> insertToCar(List<Product> carrello, @RequestBody Product prodotto){
		
		System.out.println("POST aggiungi");		
		System.out.println("prodotto aggiunto al carrello : " + prodotto);
		
		prodottoService.addToCar(carrello, prodotto);
		
		return carrello;	
	}
	
	
	
	
}
