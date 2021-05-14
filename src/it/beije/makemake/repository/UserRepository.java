package it.beije.makemake.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.makemake.entity.User;
public interface UserRepository extends JpaRepository<User, Integer>{

	
public User findByUsernameAndPassword(String username,String password);
}
