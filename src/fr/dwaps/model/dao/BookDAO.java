package fr.dwaps.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.dwaps.model.beans.Book;
import fr.dwaps.web.util.JpaUtil;

public class BookDAO implements InterfaceDAO<Book> {
	private EntityManager em;
	
	public BookDAO() {
		em = JpaUtil.getEntityManager();
	}

	@Override
	public List<Book> findAll() {
		TypedQuery<Book> query = em.createQuery("from Book", Book.class);
		List<Book> books = query.getResultList();
		em.close();
		return books;
	}

	@Override
	public Book find(int id) {
		Book book = em.find(Book.class, id);
		em.close();
		return book;
	}

	@Override
	public void delete(int id) { executeUpdate(em.find(Book.class, id), true); }

	@Override
	public void update(Book book) { executeUpdate(em.merge(book), false); }

	@Override
	public void create(Book book) { executeUpdate(book, false); }
	
	private void  executeUpdate(Book book, boolean remove) {
		EntityTransaction transaction = em.getTransaction();
		
		try {
			transaction.begin();
			if (!remove) em.persist(book);
			else em.remove(book);
			transaction.commit();
		}
		catch (Exception e) { transaction.rollback(); }
		finally { if (em.isOpen()) em.close(); }
	}
}
