package it.beije.makemake.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.makemake.ecommerce.User;




@Repository
public interface UserRepository extends JpaRepository<User, Integer> { 

	
	
}
