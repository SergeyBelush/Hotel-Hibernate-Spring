package by.htp3.hotel.controller;

import by.htp3.hotel.bean.Order;
import by.htp3.hotel.bean.User;
import by.htp3.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    protected UserService userService;


    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView index() {

        System.out.println("inside indexxxxxxxxxxxxxxxxxxx");
        return new ModelAndView("/index", "user", new User());
    }

    @RequestMapping(value = "/checkuser", method = RequestMethod.POST)
    public ModelAndView checkUser(@ModelAttribute("user") User user) throws Exception {

        System.out.println("inside checkUserrrrrrrrrrrrrrrrr" + " Login " + user.getLogin() +
                " Pass " + user.getPass());

        User u = userService.authorisation(user.getLogin(), user.getPass());

        if(u != null) {

            UsernamePasswordAuthenticationToken token =
                    new UsernamePasswordAuthenticationToken(u.getLogin(), u.getPass());
            SecurityContextHolder.getContext().setAuthentication(token);

            List<Order> orders = userService.getOrders(u.getLogin());

            Map<String, Object> map = new HashMap<>();
            map.put("user", u);
            map.put("orders", orders);

            return new ModelAndView("/user/user", map);
        } else {
            return new ModelAndView("/index", "errorMessage", "Wrong login or password!!!");
        }
    }

    @RequestMapping(value = {"/checkuser", "/registeraccount", "/register"}, method = RequestMethod.GET)
    public ModelAndView checkuser() throws Exception {
        return index();
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register() {

        System.out.println("inside regiserrrrrrrrrrrrr");

        return new ModelAndView("/user/registeraccount", "registeraccount", new User());
    }


    @RequestMapping(value = "/registeraccount", method = RequestMethod.POST)
    public ModelAndView registerAccount(@ModelAttribute("registeraccount") User user) {

        User user1 = userService.register(user.getName(), user.getSurname(), user.getLogin(),
                user.getPass(), user.getMail());

        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(user1.getLogin(), user1.getPass());
        SecurityContextHolder.getContext().setAuthentication(token);

        return new ModelAndView("/user/user", "user", user1);
    }


}
