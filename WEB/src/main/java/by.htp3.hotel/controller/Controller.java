package by.htp3.hotel.controller;

import java.io.IOException;
import java.util.Random;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.htp3.hotel.command.Command;
import by.htp3.hotel.command.impl.AddNewRoom;
import by.htp3.hotel.command.impl.GetFreeRooms;

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

/*
		int x = new Random().nextInt(2);
		Command may;
		if (x == 0){
			may = new AddNewRoom();
		} else {
			may = new GetFreeRooms();
		}
		may.execute(request, response);
*/
	}


	public static void redirect(String page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(page).forward(request, response);
	}


}












	/*public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException{

		String myParam = request.getParameter("command");

		if(!"blockTheRequest".equals(myParam)){
			filterChain.doFilter(request, response);
		}
	}

	public void destroy() {
	}*/