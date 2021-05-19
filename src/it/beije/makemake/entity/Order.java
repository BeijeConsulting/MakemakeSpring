package it.beije.makemake.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@Table(name = "\"Order\"")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private LocalDateTime date;

	@Column(name = "id_user")
	private Integer userId;

	@Column
	private String status;

	@Column
	private BigDecimal total;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_order")
	@JsonInclude(value = Include.NON_EMPTY)
	private List<OrderItem> orderItems;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	@JsonGetter(value = "date")
	public String getStringDate() {
		return date.format(DateTimeFormatter.ISO_DATE);
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@JsonSetter
	public void setDate(String date) {
		this.date = LocalDateTime.parse(date, DateTimeFormatter.ISO_DATE);
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

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "Order [date=" + date + ", status=" + status + ", total=" + total + "]";
	}

}

//CREATE TABLE `makemake`.`order` (
//		  `id` INT NOT NULL AUTO_INCREMENT,
//		  `date` DATETIME NOT NULL,
//		  `id_user` INT NOT NULL,
//		  `status` VARCHAR(45) NOT NULL,
//		  `total` DECIMAL NOT NULL,
//		  PRIMARY KEY (`id`));
