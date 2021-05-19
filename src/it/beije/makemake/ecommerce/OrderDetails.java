package it.beije.makemake.ecommerce;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderDetails {

	private Integer orderId;
	private Integer orderItemQuantity;
	private String name;
	private String brand;
	private String description;
	private Double price;

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public OrderDetails() {
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getOrderItemQuantity() {
		return orderItemQuantity;
	}

	public void setOrderItemQuantity(Integer orderItemQuantity) {
		this.orderItemQuantity = orderItemQuantity;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("{id : ").append(orderId).append(", ")
				.append("name : ").append(name).append(", ")
				.append("brand : ").append(brand).append(", ")
				.append("desc : ").append(description).append(", ")
				.append("Quantity : ").append(orderItemQuantity).append(" }");
		return builder.toString();
	}
	

}
