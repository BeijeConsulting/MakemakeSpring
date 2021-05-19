package it.beije.makemake;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@Entity
@Table(name = "`order`")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column
	private LocalDateTime date;
	
	@Column(name = "id_user")
	private Integer userId;
	
	@Column
	private String status;
	
	@Column
	private Double total;
	
	@JsonIgnore
	@Transient
	private String testField;

	@JsonInclude(value = Include.NON_NULL)
	@Transient
	private String testNull;// = "prova";
	
	
	public String getTestNull() {
		return testNull;
	}

	public void setTestNull(String testNull) {
		this.testNull = testNull;
	}

	public String getTestField() {
		return testField;
	}

	public void setTestField(String testField) {
		this.testField = testField;
	}

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

//	public String getHour() {
//		return date.format(DateTimeFormatter.ISO_TIME);
//	}


	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	@JsonSetter
	public void setDate(String date) {
		this.date = LocalDateTime.parse(date, DateTimeFormatter.ISO_TIME);
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
