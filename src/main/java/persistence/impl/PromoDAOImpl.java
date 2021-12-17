package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Atraccion;
import model.Promocion;
import model.Taquilla;
import persistence.PromoDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;
import promociones.PromoAbsoluto;
import promociones.PromoAxB;
import promociones.PromoPorcentual;

public class PromoDAOImpl implements PromoDAO{

	public List<Promocion> findAll(/*Taquilla taquilla, List<Atraccion> listaAtracciones*/) {
		try {
			
			Taquilla taquilla = new Taquilla();
			String sql = "SELECT promociones.*, group_concat(ap.idAtracciones) AS \"atracciones\"\n" + "FROM promociones\n"
					+ "JOIN atracciones_En_Promocion ap ON ap.idPromocion = promociones.id \n" + "GROUP BY promociones.id";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();
	
			Promocion promo = null;
	
			List<Promocion> promocion = new LinkedList<Promocion>();
	
			while (resultados.next()) {
				List<Atraccion> atraccionesIncluidas = new ArrayList<Atraccion>();
	
				String tipoPromocion = resultados.getString("tipoDeDescuento");
	
				String idAtraccion = resultados.getString("atracciones");
				String[] idSpliteado = idAtraccion.split(",");
	
				for (String id : idSpliteado) {
					int idUsable = Integer.parseInt(id);
					atraccionesIncluidas.add(taquilla.obtenerAtraccionPorIDAtraccion(idUsable));
					}
				
	
				switch (tipoPromocion) {
					case "PromoPorcentual": 
						promo = new PromoPorcentual(resultados.getString("nombre"), resultados.getInt("tipoPromo"),
								atraccionesIncluidas, resultados.getInt("datoDescuento"));
						break;
					
					case "PromoAxB": 
						promo = new PromoAxB(resultados.getString("nombre"), resultados.getInt("tipoPromo"),
								atraccionesIncluidas, resultados.getInt("datoDescuento"));
						break;
					
					case "PromoAbsoluta": 
						promo = new PromoAbsoluto(resultados.getString("nombre"), resultados.getInt("tipoPromo"),
								atraccionesIncluidas, resultados.getInt("datoDescuento"));
						break;
				}
	
				promocion.add(promo);
			}
	
			return promocion;
			
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
		
		
	}

	@Override
	public Promocion find(Integer id) {
		/*
		try {
			String sql = "SELECT * FROM promociones WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			
			ResultSet resultados = statement.executeQuery();

			Promocion promo = null;
			if (resultados.next()) {
				promo = toPromo(resultados);
			}

			return promo;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
		*/
		return null;
	}
	
	
	private Promocion toPromo(ResultSet promoRegister) throws SQLException {
		/*return new Promocion(promoRegister.getInt(1), promoRegister.getString(2), promoRegister.getString(3), promoRegister.getInt(5));*/
		return null;
	}

	@Override
	public int insert(Promocion promocion) {
		/*
		try {
			String sql = "INSERT INTO promociones (nombre, tipoDeDescuento, datoDescuento, tipoPromo) VALUES (?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			int i = 1;
			statement.setString(i++, promocion.getNombre());
			statement.setInt(i++, promocion.getTipoPromo());
			statement.setInt(i++, promocion.getTiempo());
			statement.setString(i++, promocion.getDescripcion());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
		*/
		return 0;
	}

	@Override
	public int update(Promocion promocion) {
		
		/*try {
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
		}*/
		return 0;
	}

	@Override
	public int delete(Promocion promocion) {
		
		/*try {
			String sql = "DELETE FROM atracciones WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, attraction.getID());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}*/
		return 0;
	}

	@Override
	public int countAll() {
		/*try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM atracciones";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			resultados.next();
			int total = resultados.getInt("TOTAL");

			return total;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}*/
		
		return 0;
	}
}
