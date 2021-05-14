package it.beije.makemake.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.makemake.ecommerce.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
