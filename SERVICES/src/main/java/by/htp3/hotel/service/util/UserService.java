package by.htp3.hotel.service.util;


import by.htp3.hotel.bean.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserService {

    public static List<User> getUserList(String login, String password) {

        Session session = HibernateUtil.getSession();

        String hql = "SELECT x from User x where x.login= :login and x.pass= :password";

        Query query = session.createQuery(hql);
        query.setParameter("login", login);
        query.setParameter("password", password);
        query.setCacheable(true);

        return query.list();

    }

/*    public static void deleteUser(String userLogin) {

        HibernateUtil.deleteEntity(userLogin, "User", "login");

    }*/

    public static void deleteUser(String value, String tableName, String columnName){

        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM " + tableName + " WHERE " + columnName + " = :val");
        query.setParameter("val", value);

        query.executeUpdate();
        transaction.commit();
    }
}


