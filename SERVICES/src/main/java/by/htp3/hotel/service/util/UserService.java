package by.htp3.hotel.service.util;

import by.htp3.hotel.bean.User;
import by.htp3.hotel.dao.impl.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    @Transactional
    public List<User> getUserList(String login, String password) {

        return userDAO.getListUsers(login, password);
    }

    @Transactional
    public void deleteUser(){

       userDAO.delete("1");
    }

    @Transactional
    public User authorisation(String login, String password) throws Exception {

        return userDAO.authorisation(login, password);
    }

    @Transactional
    public void register(String name, String surname, String login, String pass, String mail) {
        userDAO.register(name, surname, login, pass, mail);
    }
}


