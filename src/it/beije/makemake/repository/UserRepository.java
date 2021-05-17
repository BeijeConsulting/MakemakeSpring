package it.beije.makemake.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.makemake.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByUsernameAndPassword(String username, String password);
}
