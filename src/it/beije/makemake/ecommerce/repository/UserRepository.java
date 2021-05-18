package it.beije.makemake.ecommerce.repository;

import org.springframework.stereotype.Repository;

import it.beije.makemake.ecommerce.entity.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public Optional<User> findByUsername(String username);
}
