package it.beije.makemake.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.makemake.ecommerce.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
