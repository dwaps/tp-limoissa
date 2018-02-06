package fr.dwaps.business;

import javax.servlet.http.HttpServletRequest;

import fr.dwaps.model.dao.DAOFactory;
import fr.dwaps.web.util.AbstractAction;
import fr.dwaps.web.util.Constants;

public class DeleteBookAction extends AbstractAction {
	private static final String JSP_PAGE = Constants.JSP_BOOKS_NAME;
	
	@Override
	public String executeAction(HttpServletRequest request) {
		request.setAttribute("reload", true);
		
		String idStr = request.getParameter("id");
		
		if (idStr != null) {
			try {
				long id = Long.parseLong(idStr);
				DAOFactory.getBookDAO().delete(id);
			}
			catch (Exception e) { e.printStackTrace(); }
		}
		
		return JSP_PAGE;
	}

}
