package services;

import java.util.List;

import model.Atraccion;
import persistence.AttractionDAO;
import persistence.commons.DAOFactory;

public class AttractionService {

	public List<Atraccion> list() {
		return DAOFactory.getAttractionDAO().findAll();
	}

	public Atraccion create(String nombre, Integer costo, Integer tiempo, Integer cupo, Integer tipo, String descripcion) {

		Atraccion attraction = new Atraccion(nombre, costo, tiempo, cupo, tipo, descripcion);

		if (attraction.isValid()) {
			AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
			attractionDAO.insert(attraction);
		}

		return attraction;
	}

	public Atraccion update(Integer id, String nombre, Integer costo, Integer tiempo, Integer cupo, Integer tipo, String descripcion) {

		AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
		Atraccion attraction = attractionDAO.find(id);

		attraction.setNombre(nombre);
		attraction.setCosto(costo);
		attraction.setTiempoEnMinutos(tiempo);
		attraction.setCupo(cupo);
		attraction.setTipoDeAtraccion(tipo);
		attraction.setDescripcion(descripcion);

		if (attraction.isValid()) {
			attractionDAO.update(attraction);
		}

		return attraction;
	}

	public void delete(Integer id) {
		Atraccion attraction = new Atraccion(id, null, null, null, null, null, null);

		AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
		attractionDAO.delete(attraction);
	}

	public Atraccion find(Integer id) {
		return DAOFactory.getAttractionDAO().find(id);
	}

}
