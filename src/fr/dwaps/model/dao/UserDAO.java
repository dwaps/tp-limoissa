package fr.dwaps.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.dwaps.model.beans.User;
import fr.dwaps.web.util.JpaUtil;

public class UserDAO implements InterfaceDAO<User> {
	private EntityManager em;
	
	public UserDAO() {
		em = JpaUtil.getEntityManager();
	}
	
	public User findByPseudo(String pseudo) {
		User user = (User) em
			.createQuery("SELECT u FROM User u WHERE u.pseudo = :pseudo")
            .setParameter("pseudo", pseudo)
            .getSingleResult();
		
		em.close();
		return user;
	}

	@Override
	public List<User> findAll() {
		TypedQuery<User> query = em.createQuery("FROM User", User.class);
		List<User> users = query.getResultList();
		em.close();
		return users;
	}

	@Override
	public User find(int id) {
		User user = em.find(User.class, id);
		em.close();
		return user;
	}

	@Override
	public void delete(int id) { executeUpdate(em.find(User.class, id), true); }

	@Override
	public void update(User user) { executeUpdate(em.merge(user), false); }

	@Override
	public void create(User user) { executeUpdate(user, false); }
	
	private void  executeUpdate(User user, boolean remove) {
		EntityTransaction transaction = em.getTransaction();
		
		try {
			transaction.begin();
			if (!remove) em.persist(user);
			else em.remove(user);
			transaction.commit();
		}
		catch (Exception e) { transaction.rollback(); }
		finally { if (em.isOpen()) em.close(); }
	}
}
