package fr.dwaps.model.dao;

import fr.dwaps.model.beans.Book;
import fr.dwaps.model.beans.User;

public final class DAOFactory {
	private DAOFactory() {}
	
	public static InterfaceDAO<Book> getBookDAO() {
		return new BookDAO();
	}
	public static InterfaceDAO<User> getUserDAO() {
		return new UserDAO();
	}
	
}
