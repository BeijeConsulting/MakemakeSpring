package it.beije.makemake;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String name;

	@Column
	private String brand;

	@Column
	private String description;

	@Column
	private double price;
	
	@Column
	private String image;
	
	@Column
	private Integer quantity;
	
	
	//Id________________________________________________________
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	//Name________________________________________________________
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	//Brand________________________________________________________
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	//Desc________________________________________________________
	public String getDescription() {
		return description;
	}

	public void setDescription(String desc) {
		this.description = desc;
	}
	//Price________________________________________________________
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	//Image________________________________________________________
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	//Qunatity________________________________________________________
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer qunatity) {
		this.quantity = qunatity;
	}
	//________________________________________________________

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", desc=" + description + ", image=" + image + ", qunatity=" + quantity + "]";
	}
	
}