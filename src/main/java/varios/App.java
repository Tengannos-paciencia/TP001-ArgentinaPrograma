package varios;

import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import dao.AtraccionDAO;
import dao.ItinerarioDAO;
import dao.PromocionDAO;
import dao.UsuarioDAO;
import model.Atraccion;
import model.Promocion;
import model.Taquilla;
import model.Usuario;
import ofertable.ComparadorDeOfertables;
import ofertable.Ofertable;

public class App {

	public static void main(String[] args) throws SQLException {
		Taquilla nuevaTaquilla = new Taquilla();
		UsuarioDAO uDAO = new UsuarioDAO();
		AtraccionDAO aDAO = new AtraccionDAO();
		PromocionDAO pDAO = new PromocionDAO();
		ItinerarioDAO iDAO = new ItinerarioDAO();
		Scanner consolita = new Scanner(System.in);
		String respuesta = "";

		nuevaTaquilla.agregarTodosLosUsuarios(uDAO.findAll());

		List<Usuario> usuarios = nuevaTaquilla.getUsuarios();

		nuevaTaquilla.agregarTodasLasAtracciones(aDAO.findAll());

		List<Atraccion> atracciones = nuevaTaquilla.getAtracciones();

		nuevaTaquilla.agregarTodasLasPromociones(pDAO.findAll(nuevaTaquilla, atracciones));

		List<Ofertable> ofertas = new LinkedList<Ofertable>();

		ofertas.addAll(nuevaTaquilla.getPromociones());
		ofertas.addAll(nuevaTaquilla.getAtracciones());

		for (int i = 0; i < usuarios.size(); i++) {
			uDAO.atraccionesCompradas(usuarios.get(i), nuevaTaquilla);
			int atraccionFavorita = usuarios.get(i).getTipoAtraccion();

			Collections.sort(ofertas, new ComparadorDeOfertables(atraccionFavorita));

			System.out.println("*****Bienvenide " + usuarios.get(i).getNombre() + " al Parque del terror*****\n\n");

			for (int j = 0; j < ofertas.size(); j++) {
				Ofertable oferta = ofertas.get(j);
				if (usuarios.get(i).puedeComprar(oferta) && !usuarios.get(i).atraccionYaComprada(oferta)
						&& oferta.cupoDisponible()) {
					respuesta = "";
					System.out.println(oferta);
					while (!respuesta.equalsIgnoreCase("Y") && !respuesta.equalsIgnoreCase("N")) {
						System.out.println();
						System.out.println("Desea aceptar esta oferta? (Y/N)");
						respuesta = consolita.nextLine();

					}
					if (respuesta.equalsIgnoreCase("Y")) {
						usuarios.get(i).aceptarOfertado(oferta);
						System.out.println("Gracias por su compra " + usuarios.get(i).getNombre() + "\n"
								+ "(dinero restante: " + usuarios.get(i).getDineroDisponible() + " monedas,"
								+ " tiempo restante: " + usuarios.get(i).getTiempoDisponible() + " minutos)" + "\n\n");
						System.out.println(
								"-----------------------------------------------------------------------------------------------------");
						iDAO.insert(usuarios.get(i), oferta);
						if (oferta.esPromocion()) {
							for (Atraccion atraccion : oferta.getListaAtracciones()) {
								aDAO.update(atraccion);
							}
						}
						else {
							aDAO.update((Atraccion) oferta);
						}
						
					}

					System.out.println("-----------------------------------");

				}

			}
			uDAO.update(usuarios.get(i));
		}

		for (int i = 0; i < 50; ++i)
			System.out.println();
		System.out.println("--------Muchas gracias por visitar nuestro parque, vuelva prontos--------");

		consolita.close();
	}

}
