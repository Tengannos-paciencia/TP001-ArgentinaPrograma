package services;

import java.util.HashMap;
import java.util.Map;

import model.Atraccion;
import model.Usuario;
import persistence.AttractionDAO;
import persistence.UserDAO;
import persistence.commons.DAOFactory;

public class BuyAttractionService {

	AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
	UserDAO userDAO = DAOFactory.getUserDAO();

	public Map<String, String> buy(Integer userId, Integer attractionId) {
		Map<String, String> errors = new HashMap<String, String>();

		Usuario user = userDAO.find(userId);
		Atraccion attraction = attractionDAO.find(attractionId);

		if (!attraction.cupoDisponible()) {
			errors.put("attraction", "No hay cupo disponible");
		}
		if (!user.puedeCostear(attraction)) {
			errors.put("user", "No tienes dinero suficiente");
		}
		if (!user.tiempoDisponible(attraction)) {
			errors.put("user", "No tienes tiempo suficiente");
		}

		if (errors.isEmpty()) {
			user.aceptarOfertado(attraction);
			attraction.ocuparAtraccion();

			attractionDAO.update(attraction);
			userDAO.update(user);
		}

		return errors;

	}

}
