package it.beije.makemake.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.makemake.ecommerce.OrderItem;

public interface OrderItemRepostory extends JpaRepository<OrderItem, Integer> {

}
