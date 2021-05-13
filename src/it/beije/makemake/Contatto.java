package it.beije.makemake;


public class Contatto {

	private String name;
	private String surname;
	private String telephone;
	private String email;


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

