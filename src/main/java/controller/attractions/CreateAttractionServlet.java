package controller.attractions;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import services.AttractionService;

@WebServlet("/atracciones/create.do")
public class CreateAttractionServlet extends HttpServlet {

	private static final long serialVersionUID = 3455721046062278592L;
	private AttractionService attractionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.attractionService = new AttractionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/atracciones/create.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		Integer costo = Integer.parseInt(req.getParameter("costo"));
		Integer tiempo = Integer.parseInt(req.getParameter("tiempo"));
		Integer cupo = Integer.parseInt(req.getParameter("cupo"));
		Integer tipo = Integer.parseInt(req.getParameter("tipo"));
		String descripcion = req.getParameter("descripcion");

		Atraccion attraction = attractionService.create(nombre, costo, tiempo, cupo, tipo, descripcion);
		
		if (attraction.isValid()) {
			resp.sendRedirect("index.do");
		} else {
			req.setAttribute("attraction", attraction);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/atracciones/create.jsp");
			dispatcher.forward(req, resp);
		}

	}

}
