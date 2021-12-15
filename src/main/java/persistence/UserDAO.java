package persistence;

import model.Usuario;
import persistence.commons.GenericDAO;

public interface UserDAO extends GenericDAO<Usuario> {

	public abstract Usuario findByUsername(String username);
	
}
