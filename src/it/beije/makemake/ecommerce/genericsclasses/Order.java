package it.beije.makemake.ecommerce.genericsclasses;

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
@Table(name = "\"Order\"")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column
	private LocalDateTime date;
	
	@Column(name = "id_user")
	private Integer userId;
	
	@OneToMany(cascade=CascadeType.ALL/*, fetch=FetchType.EAGER*/)
	@JoinColumn(name="id_order")
	private List<OrderItem> orderitem;
	
	@Column
	private String status;
	
	@Column
	private Double total;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
	public List<OrderItem> getOrderItem() {
		return orderitem;
	}

	public void setOrderItem(List<OrderItem> orderitem) {
		this.orderitem = orderitem;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	
	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("{ id : ").append(id).append(", ")
				.append("userId : ").append(userId).append(", ")
				.append("total : ").append(total).append(", ")
				.append("date : ").append(date).append(", ")
				.append("status : ").append(status).append(" }");
		
		return builder.toString();
	}
}
