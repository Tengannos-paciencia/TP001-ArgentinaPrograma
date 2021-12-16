package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Atraccion;
import persistence.AttractionDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class AttractionDAOImpl implements AttractionDAO {

	public List<Atraccion> findAll() {
		try {
			String sql = "SELECT * FROM atracciones";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<Atraccion> attractions = new LinkedList<Atraccion>();
			while (resultados.next()) {
				attractions.add(toAttraction(resultados));
			}

			return attractions;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public Atraccion find(Integer id) {
		try {
			String sql = "SELECT * FROM atracciones WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			
			ResultSet resultados = statement.executeQuery();

			Atraccion attraction = null;
			if (resultados.next()) {
				attraction = toAttraction(resultados);
			}

			return attraction;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	private Atraccion toAttraction(ResultSet attractionRegister) throws SQLException {
		return new Atraccion(attractionRegister.getInt(1), attractionRegister.getString(2),
				attractionRegister.getInt(3), attractionRegister.getInt(4), attractionRegister.getInt(5), attractionRegister.getInt(6), attractionRegister.getString(7));
	}

	@Override
	public int insert(Atraccion attraction) {
		try {
			String sql = "INSERT INTO atracciones (nombre, costo, tiempo, cupoDisponible, tipoAtraccion, descripcion) VALUES (?, ?, ?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			int i = 1;
			statement.setString(i++, attraction.getNombre());
			statement.setInt(i++, attraction.getCosto());
			statement.setInt(i++, attraction.getTiempo());
			statement.setInt(i++, attraction.getCupo());
			statement.setInt(i++, attraction.getTipo());
			statement.setString(i++, attraction.getDescripcion());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int update(Atraccion attraction) {
		try {
			String sql = "UPDATE atracciones SET nombre = ?, costo = ?, tiempo = ?, cupoDisponible = ?, tipoAtraccion = ?,  descripcion = ? WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();
			
			PreparedStatement statement = conn.prepareStatement(sql);
			int i = 1;
			statement.setString(i++, attraction.getNombre());
			statement.setInt(i++, attraction.getCosto());
			statement.setInt(i++, attraction.getTiempo());
			statement.setInt(i++, attraction.getCupo());
			statement.setInt(i++, attraction.getTipo());
			statement.setString(i++, attraction.getDescripcion());
			statement.setInt(i++, attraction.getId());
			int rows = statement.executeUpdate();
			
			
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int delete(Atraccion attraction) {
		try {
			String sql = "DELETE FROM atracciones WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, attraction.getID());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int countAll() {
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM atracciones";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			resultados.next();
			int total = resultados.getInt("TOTAL");

			return total;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}



}
