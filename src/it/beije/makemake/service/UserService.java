package it.beije.makemake.service;

import javax.persistence.PersistenceException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import it.beije.makemake.User;
import it.beije.makemake.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User login(String username, String password) {
		User user = null;
		if (username == null || username.trim().length() == 0 || password == null || password.trim().length() == 0) {
			throw new IllegalArgumentException("Username o password non sono valide");
		} else {
			user = userRepository.findByUsernameAndPassword(username, password);
		}
		return user;
	}

	public User register(String name, String surname, String username, String password) {
		User user = null;
		if (username == null || username.trim().length() == 0 || password == null || password.trim().length() == 0) {
			throw new IllegalArgumentException("Username o password non sono valide");
		} else {
			user = new User();
			user.setName(name);
			user.setSurname(surname);
			user.setUsername(username);
			user.setPassword(password);
			try {
				user = userRepository.save(user);
			} catch (PersistenceException e) {
				throw new PersistenceException("Esiste già un utente registrato con questa username");
			}
		}
		return user;
	}

	public User modificaUtente(User oldUser, String name, String surname, String username, String password) {
	User user = null;
	if (username == null || username.trim().length() == 0 || password == null || password.trim().length() == 0 || 
			 name == null || name.trim().length() == 0 || surname == null || surname.trim().length() == 0) {
		throw new IllegalArgumentException("Username o password non sono valide");
	}
	else {
		user.setName(name);
		user.setSurname(surname);
		user.setUsername(username);
		user.setPassword(password);
		try {
			oldUser = user;
		} catch (PersistenceException e) {
			throw new PersistenceException("Esiste già un utente registrato con questa username");
		}
	}
	return oldUser;
	}

	public User modifyUser(User user, String name, String surname, String username, String password) {
		if ((name == null || name.trim().length() == 0) && (surname == null || surname.trim().length() == 0)
				&& (username == null || username.trim().length() == 0)
				&& (password == null || password.trim().length() == 0)) {
			return user;
		}
		user = userRepository.findById(user.getId()).get();
		user.setName((name == null || name.trim().length() == 0) ? user.getName() : name);
		user.setSurname((surname == null || surname.trim().length() == 0) ? user.getSurname() : surname);
		user.setUsername((username == null || username.trim().length() == 0) ? user.getUsername() : username);
		user.setPassword((password == null || password.trim().length() == 0) ? user.getPassword() : password);
		try {
			user = userRepository.save(user);
		} catch (JpaSystemException e) {
			throw new PersistenceException("Esiste già un utente registrato con questa username");
		}
		return user;
	}

}
