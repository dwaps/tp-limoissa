package fr.dwaps.model.dao;

import fr.dwaps.model.beans.Book;

public final class DAOFactory {
	private DAOFactory() {}
	
	public static InterfaceDAO<Book> getBookDAO() {
		return new BookDAO();
	}
	
}
