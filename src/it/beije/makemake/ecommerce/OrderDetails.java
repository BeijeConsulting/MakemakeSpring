package it.beije.makemake.ecommerce;

public class OrderDetails {

	private Integer orderId;
	private Integer orderItemQuantity;
	private String name;
	private String brand;
	private String description;

	public OrderDetails() {}
	
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
	
	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("{ Order ID : ").append(orderId).append("\n ")
				.append("Name : ").append(name).append("\n ")
				.append("Brand : ").append(brand).append("\n ")
				.append("Brand : ").append(description).append("\n ")
				.append("Quantity : ").append(orderItemQuantity).append(" }");
		
		return builder.toString();
	}
	

}
