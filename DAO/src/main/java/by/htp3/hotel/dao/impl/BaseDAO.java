package by.htp3.hotel.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDAO<T> {

    @Autowired
    private SessionFactory sessionFactory;

    public BaseDAO (SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

    public BaseDAO() {
    }

    Session getSession() {

        return sessionFactory.getCurrentSession();
    }

    public void persistTransaction(Object object) {

        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(object);
        transaction.commit();
        session.close();
    }
}
