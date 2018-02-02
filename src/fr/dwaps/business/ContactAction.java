package fr.dwaps.business;

import javax.servlet.http.HttpServletRequest;

import fr.dwaps.web.util.AbstractAction;
import fr.dwaps.web.util.Constants;

public class ContactAction extends AbstractAction {
	private static final String JSP_PAGE = Constants.JSP_CONTACT_NAME;
	private static final String TITLE = Constants.TITLE_CONTACT_PAGE;
	
	@Override
	public String executeAction(HttpServletRequest request) {
		request.setAttribute("title", TITLE);
		return JSP_PAGE;
	}

}
