package it.beije.makemake.ecommerce;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPASingleton {

	private EntityManagerFactory factory ;
	private static JPASingleton instance;
	
	
	private JPASingleton() {}
	
	public static JPASingleton getInstance() {
		if(instance==null) {
			instance = new JPASingleton();
			instance.factory = Persistence.createEntityManagerFactory("Makemake");
		}
		return instance;
	}
	public EntityManager getEntityManager() {
		return instance.factory.createEntityManager();
	}

}
