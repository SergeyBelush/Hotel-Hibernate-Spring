package by.htp3.hotel.controller;

import by.htp3.hotel.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CommandHelper helper = CommandHelper.getInstance();
	
    public Controller() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String commandName = request.getParameter("command");
		Command command  = helper.getCommand(commandName);		
		command.execute(request, response);
	}


	public static void redirect(String page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(page).forward(request, response);
	}


}
