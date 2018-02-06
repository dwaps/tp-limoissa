package fr.dwaps.business;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import fr.dwaps.model.beans.Book;
import fr.dwaps.model.dao.DAOFactory;
import fr.dwaps.web.util.AbstractAction;
import fr.dwaps.web.util.Constants;

public class BooksAction extends AbstractAction {
	private static final String JSP_PAGE = Constants.JSP_BOOKS_NAME;
	private static final String TITLE = Constants.TITLE_BOOKS_PAGE;
	
	@Override
	public String executeAction(HttpServletRequest request) {
		request.setAttribute("title", TITLE);
		
		List<Book> books = DAOFactory.getBookDAO().findAll();
		request.setAttribute("books", books);
		
		return JSP_PAGE;
	}

}
