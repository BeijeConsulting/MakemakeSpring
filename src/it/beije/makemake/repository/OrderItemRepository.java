package it.beije.makemake.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.makemake.ecommerce.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
	public List<OrderItem> findByOrderId(Integer orderId);
}
