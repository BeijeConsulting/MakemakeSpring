package it.beije.makemake;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

@Entity
@Table(name = "order_item")
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "order_id")
	private int orderId;
	
	@Column(name = "product_id")
	private int productId;
	
	@Column
	private double price;
	
	@Column
	private int quantity;
	
	
	public int getId() {
		return id;
	}
	
	public int getOrderId() {
		return orderId;
	}
	
	public void setOrderId(int id) {
		this.orderId = id;
	}
	
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int id) {
		this.productId = id;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
