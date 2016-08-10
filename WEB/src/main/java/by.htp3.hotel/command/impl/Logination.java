package by.htp3.hotel.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.htp3.hotel.bean.User;
import by.htp3.hotel.command.Command;
import by.htp3.hotel.controller.Controller;
import by.htp3.hotel.service.ServiceFactory;
import by.htp3.hotel.service.UserService;
import by.htp3.hotel.service.exception.ServiceAuthException;
import by.htp3.hotel.service.exception.ServiceException;

public class Logination implements Command {
	private static final String LOGIN = "login";
	private static final String PASSWORD = "password";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String login = request.getParameter(LOGIN);
		String password = request.getParameter(PASSWORD);

		UserService userService = ServiceFactory.getInstance().getUserService();

		try {
			User user = userService.authorisation(login, password);

			request.setAttribute("user", user);
		
			request.getSession(true).setAttribute("user", user);

			Controller.redirect("user.jsp", request, response);
		} catch (ServiceAuthException e) {

			request.setAttribute("errorMessage", "Wrong login or password");

			request.getRequestDispatcher("index.jsp").forward(request, response);
		

		} catch (ServiceException e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
}
