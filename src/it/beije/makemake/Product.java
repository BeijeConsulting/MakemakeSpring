package it.beije.makemake;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

@Entity
@Table
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String brand;
	
	@Column
	private String descript;
	
	@Column
	private float price;
	
	@Column
	private String image;
	
	@Column
	private int quantity;
	
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getDesc() {
		return descript;
	}
	
	public void setDesc(String desc) {
		this.descript = desc;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getByName(EntityManager em, String name) {
		TypedQuery<Product> tp = em.createQuery("SELECT * FROM Product p WHERE p.name = :name", Product.class)
				.setParameter("name", name);
		Product p = tp.getSingleResult();
		return p.getId();
	}
	
	public float getPriceFromId(EntityManager em, int id) {
		TypedQuery<Product> tp = em.createQuery("SELECT p.price FROM Product p WHERE p.id == :id", Product.class)
				.setParameter("id", id);
		Product p = tp.getSingleResult();
		return p.getPrice();
	}
	
	public int getQuantityFromId(EntityManager em, int id) {
		TypedQuery<Product> tp = em.createQuery("SELECT * FROM Product p WHERE p.id == :id", Product.class)
				.setParameter("id", id);
		Product p = tp.getSingleResult();
		return p.getQuantity();
	}
}
