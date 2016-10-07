/*
package by.htp3.hotel.command.impl;

import by.htp3.hotel.bean.User;
import by.htp3.hotel.command.Command;
import by.htp3.hotel.controller.Controller;
import by.htp3.hotel.controller.UserController;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login extends UserController implements Command {
	private static final String LOGIN = "login";
	private static final String PASSWORD = "password";



	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String login = request.getParameter(LOGIN);
		String password = request.getParameter(PASSWORD);

		try {

			User user = userService.authorisation(login, password);

			request.setAttribute("user", user);

			request.getSession(true).setAttribute("user", user);

			Cookie userName = new Cookie("user", user.getLogin());
			Cookie userId = new Cookie("id", String.valueOf(user.getUserid()));

			response.addCookie(userName);
			response.addCookie(userId);

			Controller.redirect("user.jsp", request, response);

		} catch (Exception e) {

			request.setAttribute("errorMessage", e.getMessage());

			request.getRequestDispatcher("index.jsp").forward(request, response);

		}

    }
}
*/
