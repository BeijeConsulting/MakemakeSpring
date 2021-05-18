package it.beije.makemake.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.makemake.ecommerce.entity.OrderItem;
import it.beije.makemake.ecommerce.entity.Product;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>{
	public List<OrderItem> findByOrderId(Integer orderId); 
}
