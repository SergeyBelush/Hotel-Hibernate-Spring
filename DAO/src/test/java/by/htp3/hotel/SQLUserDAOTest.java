package by.htp3.hotel;

import by.htp3.hotel.bean.User;
import by.htp3.hotel.dao.exception.DAOException;
import by.htp3.hotel.dao.impl.SQLUserDAO;
import by.htp3.hotel.dao.impl.pool.ConnectionPool;
import by.htp3.hotel.dao.impl.pool.ConnectionPoolException;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.sql.Connection;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class SQLUserDAOTest
    extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SQLUserDAOTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(SQLUserDAOTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testUser() throws DAOException {

        SQLUserDAO dao = new SQLUserDAO();

        dao.register("Test", "Test", "Test", "Test", "Test@mail.ru");

        User person = dao.authorisation("Test", "Test");

        assertTrue(person != null);

        dao.delete("Test");
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