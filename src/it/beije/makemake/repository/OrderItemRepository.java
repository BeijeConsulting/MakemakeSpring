package it.beije.makemake.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.makemake.OrderItem;


@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
	
}
