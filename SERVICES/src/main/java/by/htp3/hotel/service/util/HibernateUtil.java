/*
 * Copyright (c) 2012 by VeriFone, Inc.
 * All Rights Reserved.
 *
 * THIS FILE CONTAINS PROPRIETARY AND CONFIDENTIAL INFORMATION
 * AND REMAINS THE UNPUBLISHED PROPERTY OF VERIFONE, INC.
 *
 * Use, disclosure, or reproduction is prohibited
 * without prior written approval from VeriFone, Inc.
 */
package by.htp3.hotel.service.util;

import by.htp3.hotel.bean.Room;
import by.htp3.hotel.bean.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;

import java.util.List;

public class HibernateUtil {

    private static HibernateUtil util = null;

    private static Logger log = Logger.getLogger(HibernateUtil.class);

    private static SessionFactory sessionFactory = null;

    private static final ThreadLocal<Session> sessions = new ThreadLocal<>();

    private HibernateUtil() {
        try {
            /*Configuration configuration = new Configuration().configure();
            sessionFactory = configuration.buildSessionFactory();*/
            Configuration configuration = new Configuration().configure();
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());
        } catch (Throwable ex) {
            log.error("Initial SessionFactory creation failed." + ex);
            ex.printStackTrace();
            System.exit(-7);
        }
    }

    public static Session getSession() {
        Session session = sessions.get();
        if (session == null) {
            session = sessionFactory.openSession();
            sessions.set(session);
        }
        return session;
    }

    public static void persistTransaction(Object object) {

        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(object);
        transaction.commit();
    }


    public static synchronized HibernateUtil getHibernateUtil() {
        if (util == null) {
            util = new HibernateUtil();
        }
        return util;
    }

    public static void closeSession() {
        Session session = HibernateUtil.getSession();
        session.close();

    }

    /*    public static void deleteEntity(String value, String tableName, String columnName){

        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM " + tableName + " WHERE " + columnName + " = :val");
        query.setParameter("val", value);

        query.executeUpdate();
        transaction.commit();
    }*/

}