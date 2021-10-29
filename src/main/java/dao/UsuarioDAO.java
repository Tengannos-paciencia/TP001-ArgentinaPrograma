package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import jdbc.ConnectionProvider;
import model.Usuario;

public class UsuarioDAO {
	public List<Usuario> findAll() throws SQLException{
		String sql = "SELECT * FROM usuarios";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();
		
		List<Usuario> usuarios = new LinkedList<Usuario>();
		while (resultados.next()) {
			usuarios.add(toUsuario(resultados));
		}
		
		return usuarios;
	}
	
	public int update(Usuario usuario) throws SQLException{
		String sql = "UPDATE usuarios SET dineroDisponible = ?, tiempoDisponible = ? WHERE usuarios.id = ?";
		Connection conn = ConnectionProvider.getConnection();
		
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, usuario.getDineroDisponible());
		statement.setInt(2, usuario.getTiempoDisponible());
		statement.setInt(3, usuario.getId());
		int rows = statement.executeUpdate();
		
		return rows;
	}

	private Usuario toUsuario (ResultSet resultados) throws SQLException{
		return new Usuario (resultados.getInt("id"),
				 			resultados.getString("nombre"),
				 			resultados.getInt("dineroDisponible"),
				 			resultados.getInt("tiempoDisponible"),
				 			resultados.getInt("tipoFavorito"));
	}
}