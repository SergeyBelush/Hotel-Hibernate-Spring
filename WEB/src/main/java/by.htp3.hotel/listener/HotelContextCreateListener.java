package by.htp3.hotel.listener;

import by.htp3.hotel.service.util.HibernateUtil;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HotelContextCreateListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent arg0) {

		HibernateUtil.getHibernateUtil();
		System.out.println("Connection is successful");
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

		HibernateUtil.closeSession();
		System.out.println("Destroy connection");
	}

}
