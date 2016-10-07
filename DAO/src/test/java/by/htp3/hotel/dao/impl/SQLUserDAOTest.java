package by.htp3.hotel.dao.impl;

import by.htp3.hotel.bean.User;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;



public class SQLUserDAOTest
    extends TestCase {



    public SQLUserDAOTest(String testName) {
        super(testName);
    }



    public static Test suite() {
        return new TestSuite(SQLUserDAOTest.class);
    }



    public void testUser() throws Exception {

        UserDAO dao = new UserDAO();

        dao.register("Test", "Test", "Test", "Test", "Test@mail.ru");

        User person = dao.authorisation("Test", "Test");

        assertTrue(person != null);

        dao.delete("1");
    }

}

//    public void testUser() {
//        ConnectionPool pool = new ConnectionPool();
//        try {
//            pool.init2();
//            Connection con = pool.takeConnection();
//            assertTrue(con != null);
//        } catch (ConnectionPoolException e) {
//            e.printStackTrace();
//        }
