package services;

import java.util.List;

import model.Usuario;
import persistence.commons.DAOFactory;

public class UserService {

	public List<Usuario> list() {
		return DAOFactory.getUserDAO().findAll();
	}

	public Usuario create(String username, String password, Integer coins, Integer time, Integer tipo, Integer admin) {
		Usuario user = new Usuario(username, password, coins, time, tipo, admin);
		user.setPassword(password);

		if (user.isValid()) {
			DAOFactory.getUserDAO().insert(user);
		}

		return user;
	}
	
	// TO DO update y delete
}
