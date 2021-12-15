package services;

import java.util.List;

import model.Atraccion;
import persistence.AttractionDAO;
import persistence.commons.DAOFactory;

public class AttractionService {

	public List<Atraccion> list() {
		return DAOFactory.getAttractionDAO().findAll();
	}

	public Atraccion create(String name, Integer cost, Double duration, Integer capacity) {

		Atraccion attraction = new Atraccion(name, cost, duration, capacity);

		if (attraction.isValid()) {
			AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
			attractionDAO.insert(attraction);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return attraction;
	}

	public Atraccion update(Integer id, String name, Integer cost, Double duration, Integer capacity) {

		AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
		Atraccion attraction = attractionDAO.find(id);

		attraction.setName(name);
		attraction.setCost(cost);
		attraction.setDuration(duration);
		attraction.setCapacity(capacity);

		if (attraction.isValid()) {
			attractionDAO.update(attraction);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return attraction;
	}

	public void delete(Integer id) {
		Atraccion attraction = new Atraccion(id, null, null, null, null);

		AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
		attractionDAO.delete(attraction);
	}

	public Atraccion find(Integer id) {
		return DAOFactory.getAttractionDAO().find(id);
	}

}
