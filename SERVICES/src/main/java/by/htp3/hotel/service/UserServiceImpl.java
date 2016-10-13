package by.htp3.hotel.service;

import by.htp3.hotel.bean.Order;
import by.htp3.hotel.bean.User;
import by.htp3.hotel.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUserList(String login, String password) {

        return userDao.getListUsers(login, password);
    }

    @Override
    public void deleteUser(){

       userDao.delete("1");
    }

    @Override
    public User authorisation(String login, String password) throws Exception {

        User user = null;
        try {
            user = userDao.authorisation(login, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    @Override
    public User register(String name, String surname, String login, String pass, String mail) {

        return userDao.register(name, surname, login, pass, mail);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    public List<Order> getOrders(String login) {
        return userDao.getOrders(login);
    }
}


