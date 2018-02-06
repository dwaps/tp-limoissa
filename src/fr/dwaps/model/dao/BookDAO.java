package fr.dwaps.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.dwaps.model.beans.Book;

public class BookDAO implements InterfaceDAO<Book> {

	@Override
	public List<Book> findAll() {
		Connection cnx = null;
		List<Book> books = new ArrayList<>();
		
		try {
			cnx = DAOFactory.getConnection();
			ResultSet result = cnx.createStatement().executeQuery("SELECT * from Book");
			
			while (result.next()) {
				books.add(new Book(
					result.getLong("id"),
					result.getString("title"),
					result.getString("description"),
					result.getString("author"),
					result.getString("img"),
					result.getDouble("price"),
					result.getBoolean("available")
				));
			}
		}
		catch (Exception e) { e.printStackTrace(); }
		finally { DAOFactory.closeConnection(cnx); }
		
		return books;
	}

	@Override
	public Book find(long id) {
		Connection cnx = null;
		Book book = null;
		
		try {
			cnx = DAOFactory.getConnection();
			ResultSet result = cnx.createStatement().executeQuery("SELECT * from Book WHERE id="+id);
			
			if (result.next()) {
				book = new Book(
					result.getLong("id"),
					result.getString("title"),
					result.getString("description"),
					result.getString("author"),
					result.getString("img"),
					result.getDouble("price"),
					result.getBoolean("available")
				);
			}
		}
		catch (Exception e) { e.printStackTrace(); }
		finally { DAOFactory.closeConnection(cnx); }
		
		return book;
	}

	@Override
	public void delete(long id) {
		Connection cnx = null;
		
		try {
			cnx = DAOFactory.getConnection();
			cnx.createStatement().execute("DELETE FROM Book WHERE id="+id);
		}
		catch (Exception e) { e.printStackTrace(); }
		finally { DAOFactory.closeConnection(cnx); }
	}

	@Override
	public void update(Book obj) {
	}

	@Override
	public void create(Book obj) {
	}

}
