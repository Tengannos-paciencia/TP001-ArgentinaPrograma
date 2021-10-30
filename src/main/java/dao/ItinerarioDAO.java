package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jdbc.ConnectionProvider;
import model.Usuario;
import ofertable.Ofertable;

public class ItinerarioDAO {
	//insert
	public int insert (Usuario usuario, Ofertable ofertaAceptada) throws SQLException{
		String sql = "INSERT INTO itinerarios (idUsuario, promocionesCompradas, atraccionesCompradas, costoTotal, tiempoTotal) " //cambiar a costoParcial y tiempoParcial
				   + "VALUES (?, ?, ?, ?, ?)";
		Connection conn = ConnectionProvider.getConnection();
		
		PreparedStatement statement = conn.prepareStatement(sql);
		if (ofertaAceptada.esPromocion()) {
			statement.setInt(1, usuario.getId());
			statement.setInt(2, ofertaAceptada.getID());
			statement.setNull(3, 0);
			statement.setInt(4, usuario.getCostoFinal()); 
			statement.setInt(5, usuario.getTiempoFinal());
		}
		if(ofertaAceptada.esAtraccion()) {
			statement.setInt(1, usuario.getId());
			statement.setNull(2, 0);
			statement.setInt(3, ofertaAceptada.getID());
			statement.setInt(4, usuario.getCostoFinal());
			statement.setInt(5, usuario.getTiempoFinal());
		}
		
		int rows = statement.executeUpdate();
		
		return rows;
	}
}