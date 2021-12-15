package services;

import model.Usuario;
import model.nullobjects.NullUser;
import persistence.UserDAO;
import persistence.commons.DAOFactory;

public class LoginService {

	public Usuario login(String username, String password) {
		UserDAO userDao = DAOFactory.getUserDAO();
    	Usuario user = userDao.findByUsername(username);
    	
    	if (user.isNull() || !user.checkPassword(password)) {
    		user = NullUser.build();
    	}
    	return user;
	}
	
}
