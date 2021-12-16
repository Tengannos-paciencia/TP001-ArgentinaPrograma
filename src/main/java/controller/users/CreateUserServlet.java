package controller.users;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import services.UserService;

@WebServlet("/usuarios/create.do")
public class CreateUserServlet extends HttpServlet {

	private static final long serialVersionUID = 3455721046062278592L;
	private UserService userService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.userService = new UserService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/usuarios/create.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nombre = req.getParameter("nombre");
		String password = req.getParameter("password");
		Integer dinero = Integer.parseInt(req.getParameter("dineroDisponible"));
		Integer tiempo = Integer.parseInt(req.getParameter("tiempoDisponible"));
		Integer tipo = Integer.parseInt(req.getParameter("tipo"));
		Integer admin = Integer.parseInt(req.getParameter("isAdmin"));
		
		Usuario temporal = new Usuario(nombre, password, dinero, tiempo, tipo, admin);
		System.out.println(temporal.toString());
		 
		Usuario tmp_user = userService.create(nombre, password, dinero, tiempo, tipo, admin);
		
		if (tmp_user.isValid()) {
			resp.sendRedirect("index.do");
		} else {
			req.setAttribute("tmp_user", tmp_user);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/usuarios/create.jsp");
			dispatcher.forward(req, resp);
		}

	}

}
