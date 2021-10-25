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
import promociones.PromoAbsoluto;
import promociones.PromoAxB;
import promociones.PromoPorcentual;

public class PromocionDAO {

	public List<Promocion> findAll(List<Atraccion> listaAtracciones) throws SQLException{
		String sql = "SELECT promociones.*, group_concat(ap.id_atracciones) AS \"atracciones\"\n"
				+ "FROM promociones\n"
				+ "JOIN atracciones_En_Promocion ap ON ap.id_promocion = promociones.id \n"
				+ "GROUP BY promociones.id";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();
		
		Promocion promo = null;
		AtraccionDAO atraccion_DAO = new AtraccionDAO();
		List<Atraccion> atracciones_DAO = atraccion_DAO.findAll();
		
		List<Promocion> promocion = new LinkedList<Promocion>();
		
		while (resultados.next()) {
			List<Atraccion> atraccionesIncluidas = new ArrayList<Atraccion>();
			
			String tipoPromocion = resultados.getString("tipo_DeDescuento");
			//String atracciones = resultados.getString("atracciones");
			
			String idAtraccion = resultados.getString("atracciones");
			String[] idSpliteado = idAtraccion.split(",");

			for (String id : idSpliteado) {
				int idUsable = Integer.parseInt(id);
				for (Atraccion cadaAtraccion : atracciones_DAO) {
					if (idUsable == cadaAtraccion.getId()) {
						atraccionesIncluidas.add(cadaAtraccion);
					}
				}
			}
				
			switch (tipoPromocion) {
			case "PromoPorcentual": { //tipo_promo: porcentual
				promo: new PromoPorcentual(resultados.getString("nombre"), resultados.getInt("tipoPromo"), atraccionesIncluidas, resultados.getInt("datoDescuento"));
				break;
			}
			case "PromoAxB": { //tipo_promo: AxB
				promo: new PromoAxB(resultados.getString("nombre"), resultados.getInt("tipoPromo"), atraccionesIncluidas, resultados.getInt("datoDescuento"));
				break;
			}
			case "PromoAbsoluta": { //tipo_promo: Absoluta
				promo: new PromoAbsoluto(resultados.getString("nombre"), resultados.getInt("tipoPromo"), atraccionesIncluidas, resultados.getInt("datoDescuento"));
				break;
			}

			}
			
			promocion.add(promo);
		}
		
		return promocion;
	}

}
