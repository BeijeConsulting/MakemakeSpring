package it.beije.makemake;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"order_item\"")
public class OrderItem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name= "id_order")
	private Integer orderId;
	
	@Column(name= "id_product")
	private Integer productId;
	
	@Column
	private BigDecimal price;
	
	@Column
	private Integer quantity;
	
	//Id________________________________________________________
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	//Id_order________________________________________________________
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer id_order) {
		this.orderId = id_order;
	}
	//Id_product________________________________________________________
	public Integer getProductId() {
		return productId;
	}
	
	public void setProductId(Integer id_product) {
		this.productId = id_product;
	}
	//Price________________________________________________________
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal bigDecimal) {
		this.price = bigDecimal;
	}
	//Quantity________________________________________________________
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	//________________________________________________________

	
	

	
	
}
