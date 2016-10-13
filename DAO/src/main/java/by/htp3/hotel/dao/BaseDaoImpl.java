package by.htp3.hotel.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

@Repository
@Primary
public class BaseDaoImpl<T> implements BaseDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    public BaseDaoImpl(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

    public BaseDaoImpl() {
    }

    Session getSession() {

        return sessionFactory.getCurrentSession();
    }

    public SessionFactory getSessionFactory() {

        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveOrUpdate(T t) throws Exception {
        try{
            getSession().saveOrUpdate(t);

        } catch (HibernateException e) {
            throw new Exception("Error save or update in BaseDao" + e);
        }
    }

    @Override
    public T get(Serializable id) throws Exception {
        T t;
        try {
            t = (T) getSession().get(getPersistentClass(), id);
        } catch (HibernateException e) {
            throw new Exception("Error get " + getPersistentClass() + " in BaseDao" + e);
        }
        return t;
    }

    @Override
    public void delete(T t) throws Exception {
        try {
            getSession().delete(t);

        } catch (HibernateException e) {
            throw new Exception("Error delete " + getPersistentClass() + " in BaseDao" + e);
        }
    }

    private Class getPersistentClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
