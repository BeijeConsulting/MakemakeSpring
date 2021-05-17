package it.beije.makemake.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.makemake.ecommerce.entity.Order;
import it.beije.makemake.ecommerce.entity.Product;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

}
