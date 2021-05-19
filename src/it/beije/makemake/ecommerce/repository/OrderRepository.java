package it.beije.makemake.ecommerce.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import it.beije.makemake.ecommerce.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
	public List<Order> findByUserId(Integer id);
	public Optional<Order> findByUserIdAndDate(Integer userId, LocalDateTime localDateTime);
}
