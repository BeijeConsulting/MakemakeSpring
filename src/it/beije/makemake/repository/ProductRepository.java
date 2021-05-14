package it.beije.makemake.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.makemake.ecommerce.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> { 
}
