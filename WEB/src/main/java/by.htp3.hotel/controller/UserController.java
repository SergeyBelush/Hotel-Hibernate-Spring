package by.htp3.hotel.controller;

import by.htp3.hotel.bean.User;
import by.htp3.hotel.service.util.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    protected UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {

        System.out.println("inside indexxxxxxxxxxxxxxxxxxx");
        return new ModelAndView("index", "user", new User());
        /*return "index";*/
    }

    @RequestMapping(value = "/checkuser", method = RequestMethod.POST)
    public ModelAndView checkUser(@ModelAttribute("user") User user) throws Exception {

        System.out.println("inside checkUserrrrrrrrrrrrrrrrr" + " Login " + user.getLogin() +
                " Pass " + user.getPass());

        /*userService.authorisation(user.getLogin(), user.getPass());*/

        return new ModelAndView("user", "user", user);
    }
}


/*        @RequestMapping(value = "/index",  method = RequestMethod.GET)
        public String main() {

        return "index";
    }*/

/*    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {

        return new ModelAndView("index", "user", new User());
    }


    @RequestMapping(value = "/checkuser", method = RequestMethod.POST)
    public ModelAndView checkUser(@ModelAttribute("user") User user) {

        return new ModelAndView("user", "user", user);
    }*/




/*    @RequestMapping(value = "/",  method = RequestMethod.GET)
    public String main() {

        return "index";
    }*/


/*
<form:form action="signIn" method="post" modelAttribute="user">
<form:input path="login"<br/><br/>
<form:input path="password"<br/><br/>
</form:form>

@RequestMapping(value = "/signIn", method = RequestMethod.POST)
public String signIn(@ModelAttribute("aaa") User user) {

        userService.signIn(user.getLogin(), user.getPassword());

        return "main";
        }*/



/*
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String main() {

        return "index";
    }*/



/*    @RequestMapping(value = {"/", "/user"}, method = RequestMethod.POST)
    public String authorisation(@ModelAttribute("user") User user) throws Exception {

       userService.authorisation(user.getLogin(), user.getPass());

        return "user";
    }*/