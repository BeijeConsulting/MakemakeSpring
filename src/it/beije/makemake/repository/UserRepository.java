package it.beije.makemake.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.makemake.Contatto;
import it.beije.makemake.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	//SELECT * FROM User WHERE username= ... AND password = ...
	public User findByUsernameAndPassword(String username, String password);
	
	

	
}
