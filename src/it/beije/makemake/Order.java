package it.beije.makemake;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "`order`")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column
	private LocalDate date;
	
	@Column(name = "id_user")
	private Integer userId;
	
	@Column
	private String status;
	
	@Column
	private double total;
	
	@OneToMany(cascade=CascadeType.ALL/*, fetch=FetchType.EAGER*/)
	@JoinColumn(name="id_order")
	private List<OrderItem> ordersItem;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate localDate) {
		this.date = localDate;
	}
	

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public double getTotal() {
		return total;
	}

	public void setTotal(double total2) {
		this.total = total2;
	}

	
	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("Order[ id : ").append(id).append(", ")
				.append("userId : ").append(userId).append(", ")
				.append("total : ").append(total).append(", ")
				.append("date : ").append(date).append(", ")
				.append("status : ").append(status).append(" ]");
		
		return builder.toString();
	}
	
	public List<OrderItem> getOrdersItem() {
		return ordersItem;
	}
	public void setOrdersItem(List<OrderItem> ordersItem) {
		this.ordersItem = ordersItem;
	}

}
