
package by.htp3.hotel.command.impl;

import by.htp3.hotel.command.Command;
import by.htp3.hotel.controller.Controller;
import by.htp3.hotel.controller.RoomController;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReserveRooms extends RoomController implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String internumber = request.getParameter("numbers");

        if (internumber == null || internumber.equals("")) {
            send("Please, Enter Number Room", request, response);
            return;
        }

        Long xnum = Long.valueOf(internumber);

        Cookie[] cookies = request.getCookies();
        System.out.println("Cookieeeeeeeeee " + cookies.length);
        Long userId = null;

        for(Cookie cook : cookies){
            if (cook.getName().equals("id")){
               userId = Long.valueOf(cook.getValue());
                break;
            }
        }

        if (userId == null) {
            Controller.redirect("index.jsp", request, response);
        }
        roomService.reserveRoom(xnum, userId);

        Controller.redirect("reserve.jsp", request, response);
    }

	private void send(String message, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("errorMessage", message);
		Controller.redirect("reserve.jsp", request, response);
	}

}
