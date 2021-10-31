package daoTest;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import jdbc.ConnectionProvider;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Atraccion;
import model.Usuario;
import model.Promocion;
import model.Taquilla;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import dao.UsuarioDAO;
import dao.AtraccionDAO;
import dao.PromocionDAO;
import dao.ItinerarioDAO;

public class daoTests {

	private static Connection conn;

	@BeforeClass
	public static void setUpBeforeClass() throws SQLException {
		conn = ConnectionProvider.getConnection();
		conn.setAutoCommit(false);
	}

	@Before
	public void setUp() throws SQLException {
	}

	@After
	public void tearDown() throws SQLException {
		conn.rollback();
	}

	@AfterClass
	public static void tearDownAfterClass() throws SQLException {
		conn.setAutoCommit(true);
	}
//----------------------------------------------------------------------------------------------------------------------------------------//
	//este Test da mal, pero parecieran ser iguales las 2 listas :'c
	@Test
	public void quePuedaCargarUsuariosDesdeBD() throws SQLException {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> actual = usuarioDAO.findAll();
		Usuario anthony = new Usuario(1, "Anthony", 25,300, 1);
		Usuario martin = new Usuario(2, "Martin", 37,300, 3);
		Usuario joseph = new Usuario(3, "Joseph", 56,150, 2);
		Usuario mary = new Usuario(4, "Mary", 10,270, 1);
		Usuario john = new Usuario(5, "John", 22,130, 3);
		Usuario janna = new Usuario(6, "Janna", 40,200, 1);
		
		List<Usuario> expected = new LinkedList<Usuario>();
		expected.add(anthony);
		expected.add(martin);
		expected.add(joseph);
		expected.add(mary);
		expected.add(john);
		expected.add(janna);
		
		assertEquals(expected, actual);
	}
	
	//este Test da mal, pero parecieran ser iguales las 2 listas, idem al anterior ;-;
	@Test
	public void quePuedaCargarAtraccionesDesdeBD() throws SQLException {
		AtraccionDAO atraccionDAO = new AtraccionDAO();
		
		List<Atraccion> actual = atraccionDAO.findAll();
		
		Atraccion a1 = new Atraccion(1, "El sotano", 10, 30, 4, 1);
		Atraccion a2 = new Atraccion(2, "El laberinto", 8, 25, 2, 3);
		Atraccion a3 = new Atraccion(3, "La fabrica", 14, 40, 7, 1);
		Atraccion a4 = new Atraccion(4, "La mansion", 12, 45, 10, 3);
		Atraccion a5 = new Atraccion(5, "Almas perdidas", 9, 60, 12, 2);
		Atraccion a6 = new Atraccion(6, "El pasillo", 12, 30, 2, 3);
		Atraccion a7 = new Atraccion(7, "La plantacion", 11, 50, 12, 2);
		Atraccion a8 = new Atraccion(8, "La casona", 20, 30, 20, 3);
		Atraccion a9 = new Atraccion(9, "El rincon", 5, 15, 3, 1);
		Atraccion a10 = new Atraccion(10, "Texas", 15, 90, 30, 3);
		
		List<Atraccion> expected = new LinkedList<Atraccion>();
		expected.add(a1);
		expected.add(a2);
		expected.add(a3);
		expected.add(a4);
		expected.add(a5);
		expected.add(a6);
		expected.add(a7);
		expected.add(a8);
		expected.add(a9);
		expected.add(a10);
		
		assertEquals(expected, actual);
		
	}

}
