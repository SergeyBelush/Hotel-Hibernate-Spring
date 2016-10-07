package by.htp3.hotel.dao.impl;

import by.htp3.hotel.bean.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserDAO extends BaseDAO<User> {

	public UserDAO() {
	}

	public List<User> getListUsers(String login, String password) {

		return getSession()
				.createQuery("select x from User x where x.login= :login and x.pass= :pass")
				.setParameter("login", login)
				.setParameter("pass", password)
				.setCacheable(true)
				.list();
	}

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

	public void register(String name, String surname, String login, String pass, String mail) {

		User user = new User();
		user.setName(name);
		user.setSurname(surname);
		user.setLogin(login);
		user.setPass(pass);
		user.setMail(mail);

		persistTransaction(user);
	}

	public void delete(String value)  {

		Session session = getSession();
		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("DELETE FROM User x WHERE x.login = :val");

		query.setParameter("val", value);

		query.executeUpdate();
		transaction.commit();
		session.close();
	}
}
