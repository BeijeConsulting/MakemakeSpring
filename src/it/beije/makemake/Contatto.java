package it.beije.makemake;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "rubrica")
public class Contatto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name = "nome")
	private String name;

	@Column(name = "cognome")
	private String surname;

	@Column(name = "telefono")
	private String telephone;

	@Column(name = "email")
	private String email;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFullName() {
		return name + " " + surname;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("{ nome : ").append(name).append(", ")
				.append("cognome : ").append(surname).append(", ")
				.append("telefono : ").append(telephone).append(", ")
				.append("email : ").append(email).append(" }");
		
		return builder.toString();
	}
	
}

