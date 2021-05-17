package it.beije.makemake.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.makemake.ecommerce.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	public List<Order> findByUserId(Integer userId);
}
