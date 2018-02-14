package fr.dwaps.business;

import javax.servlet.http.HttpServletRequest;

import fr.dwaps.service.BookService;
import fr.dwaps.web.util.AbstractAction;
import fr.dwaps.web.util.Constants;

public class DeleteBookAction extends AbstractAction {
	private static final String JSP_PAGE = Constants.JSP_BOOKS_NAME;
	
	@Override
	public String executeAction(HttpServletRequest request) {
		String idStr = request.getParameter("id");
		request.setAttribute("reload", true);
		
		if (idStr != null) {
			try {
				int id = Integer.parseInt(idStr);
				BookService.delete(id);
			}
			catch (Exception e) { e.printStackTrace(); }
		}
		
		return JSP_PAGE;
	}

}
