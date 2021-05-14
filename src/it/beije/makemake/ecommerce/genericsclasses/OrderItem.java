package it.beije.makemake.ecommerce.genericsclasses;

import java.time.LocalDateTime;

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
		
		@Column
		private Integer id_order;
		
		@Column
		private Integer id_product;
		
		@Column
		private double price;
		
		@Column
		private Integer quantity;

		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		
		
		public Integer getIdOr() {
			return id_order;
		}
		public void setIdOr(Integer id_order) {
			this.id_order = id_order;
		}
		
		
		public Integer getIdProd() {
			return id_product;
		}		
		public void setIdProd(Integer id_product) {
			this.id_product = id_product;
		}
		
		
		public double getPrice() {
			return price;
		}		
		public void setPrice(double price) {
			this.price = price;
		}
		
		
		public Integer getQuantity() {
			return quantity;
		}		
		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}
}