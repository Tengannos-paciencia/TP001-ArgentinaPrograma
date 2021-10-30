package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;
import model.Atraccion;
import model.Promocion;
import model.Taquilla;
import promociones.PromoAbsoluto;
import promociones.PromoAxB;
import promociones.PromoPorcentual;

public class PromocionDAO {
	
	public List<Promocion> findAll(Taquilla taquilla, List<Atraccion> listaAtracciones) throws SQLException {
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
	}

}
