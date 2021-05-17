package it.beije.makemake.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.beije.makemake.Contatto;


//@Repository
//public interface ContattoRepository extends JpaRepository<Contatto, Integer> {
//	
//	public List<Contatto> findByEmail(String email);
//
//	//SELECT * FROM rubrica WHERE name= ... OR email = ...
//	public List<Contatto> findByNameOrEmail(String name, String email);
//
//	//SELECT * FROM rubrica WHERE name= ... AND surname = ...
//	public List<Contatto> findByNameAndSurname(String name, String surname);
//
//	//SELECT * FROM rubrica WHERE name LIKE '...%'
//	@Query(nativeQuery = true, value ="SELECT * FROM rubrica WHERE nome LIKE :iniziali%")
//	//@Query(value ="SELECT * FROM Contatto as c WHERE name LIKE :letters%")
//	public List<Contatto> searchByFirstLettersOfName(@Param("iniziali") String firstLetters);
//	
//}
