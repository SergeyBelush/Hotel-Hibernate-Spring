package by.htp3.hotel.dao.impl;

import by.htp3.hotel.bean.User;
import by.htp3.hotel.dao.UserDao;
import by.htp3.hotel.dao.UserDaoImpl;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;



public class UserDaoTest
    extends TestCase {

    public UserDaoTest(String testName) {

        super(testName);
    }

    public static Test suite() {

        return new TestSuite(UserDaoTest.class);
    }

    public void testUser() throws Exception {

        UserDao dao = new UserDaoImpl();

        dao.register("Test", "Test", "Test", "Test", "Test@mail.ru");

        User person = dao.authorisation("Test", "Test");

        assertTrue(person != null);

        dao.delete("1");
    }

}
