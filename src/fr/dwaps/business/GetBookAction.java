package fr.dwaps.business;

import javax.servlet.http.HttpServletRequest;

import fr.dwaps.model.beans.Book;
import fr.dwaps.model.dao.DAOFactory;
import fr.dwaps.web.util.AbstractAction;
import fr.dwaps.web.util.Constants;

public class GetBookAction extends AbstractAction {
	private static final String JSP_PAGE = Constants.JSP_BOOK_NAME;
	private static final String TITLE = Constants.TITLE_BOOK_PAGE;
	
	@Override
	public String executeAction(HttpServletRequest request) {
		request.setAttribute("title", TITLE);
		
		String idStr = request.getParameter("id");
		if (idStr != null) {
			try {
				long id = Long.parseLong(idStr);
				Book book = DAOFactory.getBookDAO().find(id);
				request.setAttribute("book", book);
			}
			catch (Exception e) { e.printStackTrace(); }
		}
		
		return JSP_PAGE;
	}

}
