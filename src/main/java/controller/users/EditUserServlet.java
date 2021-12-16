package controller.users;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.Usuario;
import services.AttractionService;
import services.UserService;

@WebServlet("/usuarios/edit.do")
public class EditUserServlet extends HttpServlet {

	private static final long serialVersionUID = 7598291131560345626L;
	private UserService userService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.userService = new UserService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));

		Usuario user = userService.find(id);
		req.setAttribute("user", user);

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/usuarios/edit.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//todo esto tiene que coincidir con el formulario de edicion, los nombres de los tags con los getParameter y los parse mepa
		Integer id = Integer.parseInt(req.getParameter("id"));
		String nombre = req.getParameter("nombre");
		Integer presupuesto = Integer.parseInt(req.getParameter("presupuesto"));
		Integer tiempoEnMinutos = Integer.parseInt(req.getParameter("tiempoEnMinutos"));
		Integer tipo = Integer.parseInt(req.getParameter("tipo"));
		
		
		Usuario user = userService.update(id, nombre, presupuesto, tiempoEnMinutos, tipo);
		if (user.isValid()) {
			resp.sendRedirect("index.do");
		} else {
			req.setAttribute("user", user);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/usuarios/edit.jsp");
			dispatcher.forward(req, resp);
		}
	}
}



