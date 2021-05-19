package it.beije.makemake.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.makemake.Contatto;
import it.beije.makemake.ecommerce.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> { 
	public List<Product> findByName(String name);
	}
