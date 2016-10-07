package by.htp3.hotel.command.impl;

import by.htp3.hotel.command.Command;
import by.htp3.hotel.controller.Controller;
import by.htp3.hotel.controller.UserController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommandRegistration extends UserController implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String entername = request.getParameter("name");
		String entersurname = request.getParameter("surname");
		String entermail = request.getParameter("e-mail");
		String enterlogin = request.getParameter("login");
		String enterpass = request.getParameter("password");
		String repeatpass = request.getParameter("repeat-password");
		
		if (entername.trim().length() < 4) {
			send("Enter Name More 4 Symbols", request, response);
			return;
		}
		
		if (entersurname.trim().length() < 4) {
			send("Enter Surname More 4 Symbols", request, response);
			return;
		}
		
		if (!entermail.contains("@")) {
			send("Enter e-mail", request, response);
			return;
		}
		
		if (enterlogin.trim().length() < 4) {
			send("Enter Login More 4 Symbols", request, response);
			return;
		}
		
		if (enterpass.trim().length() < 6) {
			send("Enter Password More 6 Symbols", request, response);
			return;
		}
		
		if (!enterpass.equals(repeatpass)) {
			send("Passwords are not the same.", request, response);
			return;
		}
		
		try {
			userService.register(entername, entersurname, enterlogin, enterpass, entermail);
		} catch (Exception e) {
			send("Server is not available. Sorry! Please try again in 10 minutes", request, response);
		}

/*		User user = null;
		try {
			user = userService.authorisation(enterlogin, enterpass);
		} catch (Exception e) {
			Controller.redirect("index.jsp", request, response);
		}
		request.setAttribute("user", user);
		
		Controller.redirect("user.jsp", request, response);*/
	}
	
	private void send(String message, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("errorMessage", message);
		Controller.redirect("registeraccount.jsp", request, response);
	}
	
}
