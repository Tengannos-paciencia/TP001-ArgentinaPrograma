package services;

import java.util.List;

import model.Usuario;

import persistence.UserDAO;
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

	public Usuario update(Integer id, String nombre, Integer costo, Integer tiempo, Integer tipo) {

		UserDAO userDAO = DAOFactory.getUserDAO();
		Usuario user = userDAO.find(id);

		user.setNombre(nombre);
		user.setDineroDisponible(costo);
		user.setTiempoDisponible(tiempo);
		user.setTipo(tipo);

		if (user.isValid()) {
			userDAO.update(user);
		}

		return user;
	}

	public void delete(Integer id) {
		Usuario user = new Usuario(id, null, null, null, null, null, null);

		UserDAO userDAO = DAOFactory.getUserDAO();
		userDAO.delete(user);
	}

	public Usuario find(Integer id) {
		return DAOFactory.getUserDAO().find(id);
	}
}
