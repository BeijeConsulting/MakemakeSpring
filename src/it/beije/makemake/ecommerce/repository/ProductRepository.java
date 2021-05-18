package it.beije.makemake.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import it.beije.makemake.ecommerce.entity.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
