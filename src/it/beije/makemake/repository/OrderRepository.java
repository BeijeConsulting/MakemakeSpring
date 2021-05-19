package it.beije.makemake.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.makemake.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	List<Order> findByUserId(Integer userId);

}
