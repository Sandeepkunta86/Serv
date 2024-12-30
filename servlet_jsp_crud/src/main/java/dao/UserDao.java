package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.User;

public class UserDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sandeep");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public User saveUser(User user) {
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return user;
	}

	public User fetchUserById(int id) {
		User user = entityManager.find(User.class, id);
		return user;
	}

	public User fetchPersonBYEmail(String email) {
		Query query = entityManager.createQuery("select s from User s where email=?1");
		query.setParameter(1, email);
		User user = (User) query.getSingleResult();
		return user;
	}

	public List<User> fetchAllUsers() {
		Query query = entityManager.createQuery("select u from User u");
		List<User> user = query.getResultList();
		return user;
	}

	public boolean deleteUser(int id) {

		
		User user = entityManager.find(User.class, id);
		entityTransaction.begin();
		entityManager.remove(user);

		entityTransaction.commit();
		return true;
	}

	public User updateUser(User user) {
		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();
		return user;
		
	}
}
