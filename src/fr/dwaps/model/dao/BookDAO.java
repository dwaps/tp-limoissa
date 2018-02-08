package fr.dwaps.model.dao;

import static fr.dwaps.web.util.Constants.BOOK_AUTHOR;
import static fr.dwaps.web.util.Constants.BOOK_AVAILABLE;
import static fr.dwaps.web.util.Constants.BOOK_DESCRIPTION;
import static fr.dwaps.web.util.Constants.BOOK_ID;
import static fr.dwaps.web.util.Constants.BOOK_IMG;
import static fr.dwaps.web.util.Constants.BOOK_PRICE;
import static fr.dwaps.web.util.Constants.BOOK_TITLE;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
					result.getLong(BOOK_ID),
					result.getString(BOOK_TITLE),
					result.getString(BOOK_DESCRIPTION),
					result.getString(BOOK_AUTHOR),
					result.getString(BOOK_IMG),
					result.getDouble(BOOK_PRICE),
					result.getBoolean(BOOK_AVAILABLE)
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
					result.getLong(BOOK_ID),
					result.getString(BOOK_TITLE),
					result.getString(BOOK_DESCRIPTION),
					result.getString(BOOK_AUTHOR),
					result.getString(BOOK_IMG),
					result.getDouble(BOOK_PRICE),
					result.getBoolean(BOOK_AVAILABLE)
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
	public void update(Book book) {
		Connection cnx = null;
		
		try {
			cnx = DAOFactory.getConnection();
			PreparedStatement ps = cnx.prepareStatement("UPDATE Book SET "
				+ BOOK_TITLE + "=?," + BOOK_DESCRIPTION + "=?,"+ BOOK_AUTHOR + "=?,"
				+ BOOK_IMG + "=?,"+ BOOK_PRICE + "=?,"+ BOOK_AVAILABLE + "=?"
				+ " WHERE " + BOOK_ID + "=?");
			
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getDescription());
			ps.setString(3, book.getAuthor());
			ps.setString(4, book.getImg());
			ps.setDouble(5, book.getPrice());
			ps.setBoolean(6, book.isAvailable());
			ps.setLong(7, book.getId());
			
			ps.executeUpdate();
		}
		catch (Exception e) { e.printStackTrace(); }
		finally { DAOFactory.closeConnection(cnx); }
	}

	@Override
	public void create(Book book) {
		Connection cnx = null;
		
		try {
			cnx = DAOFactory.getConnection();
			PreparedStatement ps = cnx.prepareStatement("INSERT INTO Book ("
				+ BOOK_TITLE + ","+ BOOK_DESCRIPTION + ","+ BOOK_AUTHOR + ","
				+ BOOK_IMG + ","+ BOOK_PRICE + ","+ BOOK_AVAILABLE
				+ ") VALUES (?,?,?,?,?,?)");
			
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getDescription());
			ps.setString(3, book.getAuthor());
			ps.setString(4, book.getImg());
			ps.setDouble(5, book.getPrice());
			ps.setBoolean(6, book.isAvailable());
			
			ps.executeUpdate();
		}
		catch (Exception e) { e.printStackTrace(); }
		finally { DAOFactory.closeConnection(cnx); }
	}

}
