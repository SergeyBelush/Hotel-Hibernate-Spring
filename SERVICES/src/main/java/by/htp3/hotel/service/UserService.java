package by.htp3.hotel.service;

import by.htp3.hotel.bean.Order;
import by.htp3.hotel.bean.User;

import java.util.List;

public interface UserService {

    List<User> getUserList(String login, String password);

    User authorisation(String login, String password) throws Exception;

    User register(String name, String surname, String login, String pass, String mail);

    void deleteUser();

    List<Order> getOrders(String login);

}
