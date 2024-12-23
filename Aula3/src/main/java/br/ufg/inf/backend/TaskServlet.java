package br.ufg.inf.backend;

import java.io.FileNotFoundException;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/task")
public class TaskServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private TaskService service = new TaskServiceWithNotification();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.getWriter().println(service.list());
		} catch (FileNotFoundException e) {
			resp.getWriter().println(e.getMessage());
			resp.setStatus(404);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String task = req.getParameter("task");
		resp.getWriter().println(service.add(task));
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String indexString = req.getParameter("index");
		try {
			int index = Integer.parseInt(indexString);
			String task = req.getParameter("task");
			
			resp.getWriter().println(service.update(index, task));			
		} catch (NumberFormatException e) {
			resp.getWriter().println("O índice informado é inválido.");
			resp.setStatus(400);
		}
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String indexString = req.getParameter("index");
			int index = Integer.parseInt(indexString);
	
			resp.getWriter().println(service.remove(index-1));
		} catch (NumberFormatException e) {
			resp.getWriter().println("O índice informado é inválido.");
			resp.setStatus(400);
		}
	}
}
