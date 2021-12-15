package services;

import java.util.List;

import model.Atraccion;
import model.Usuario;
import persistence.AttractionDAO;
import persistence.commons.DAOFactory;

public class UserService {

	public List<Usuario> list() {
		return DAOFactory.getUserDAO().findAll();
	}

	public Usuario create(String username, String password, Integer coins, Double time) {
		Usuario user = new Usuario(-1, username, password, coins, time, false);
		user.setPassword(password);

		if (user.isValid()) {
			DAOFactory.getUserDAO().insert(user);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return user;
	}
}
