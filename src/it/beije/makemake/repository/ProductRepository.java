package it.beije.makemake.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.beije.makemake.ecommerce.genericsclasses.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	public List<Product> findByName(String name);

	//SELECT * FROM products WHERE name= ... OR email = ...
	public List<Product> findByNameOrBrand(String name, String brand);

	//SELECT * FROM product WHERE name= ... AND surname = ...
	public List<Product> findByNameAndBrand(String name, String brand);

	//SELECT * FROM product WHERE name LIKE '...%'
	@Query(nativeQuery = true, value ="SELECT * FROM product WHERE nome LIKE :iniziali%")
	//@Query(value ="SELECT * FROM Product as c WHERE name LIKE :letters%")
	public List<Product> searchByFirstLettersOfName(@Param("iniziali") String firstLetters);
	
}
