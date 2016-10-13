package by.htp3.hotel.dao;

import by.htp3.hotel.bean.Order;
import by.htp3.hotel.bean.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	public UserDaoImpl() {
	}

	@Override
	public List<User> getListUsers(String login, String password) {

		return getSession()
				.createQuery("select x from User x where x.login= :login and x.pass= :pass")
				.setParameter("login", login)
				.setParameter("pass", password)
				.setCacheable(true)
				.list();
	}

	@Override
	public User authorisation(String login, String password) throws Exception {

		List<User> users = getListUsers(login, password);

		if(users == null || users.isEmpty()) {
			System.out.println("User not found::" + login);
			throw new Exception("Wrong login or password");
		} else {
			System.out.println("User = " +  users);
			return users.get(0);
		}
	}

	@Override
	public User register(String name, String surname, String login, String pass, String mail) {

		Session session = getSession();

		User user = new User();
		user.setName(name);
		user.setSurname(surname);
		user.setLogin(login);
		user.setPass(pass);
		user.setMail(mail);
		user.setRole(0);

		session.persist(user);

		return user;
	}

	@Override
	public void delete(String value)  {

		Session session = getSession();

		Query query = session.createQuery("DELETE FROM User x WHERE x.login = :val");

		query.setParameter("val", value);

		query.executeUpdate();
	}


	public List<Order> getOrders(String login) {
		return getSession()
				.createQuery("select x from Order x where x.user.login = :login")
				.setParameter("login", login)
				.setCacheable(true)
				.list();
	}
}
