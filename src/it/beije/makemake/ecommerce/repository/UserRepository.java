package it.beije.makemake.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.makemake.ecommerce.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public Optional<User> findByUsername(String username);
	public Optional<User> findByUsernameAndPassword(String username, String password);
}
