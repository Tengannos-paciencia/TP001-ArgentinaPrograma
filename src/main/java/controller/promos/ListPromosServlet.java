package controller.promos;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.Promocion;
import services.AttractionService;
import services.PromosService;

@WebServlet("/promociones/index.do")
public class ListPromosServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -8346640902238722429L;
	private AttractionService attractionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.attractionService = new AttractionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Promocion> promos = PromosService.list();	
		req.setAttribute("promos", promos);

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/promos/index.jsp");
		dispatcher.forward(req, resp);

	}

}
