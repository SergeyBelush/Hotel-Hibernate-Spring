package by.htp3.hotel.dao;

import by.htp3.hotel.bean.Order;
import by.htp3.hotel.bean.User;
import java.util.List;

public interface UserDao {

    List<User> getListUsers(String login, String password);

    User authorisation(String login, String password) throws Exception;

    User register(String name, String surname, String login, String pass, String mail);

    void delete(String value);

    List<Order> getOrders(String login);

}
