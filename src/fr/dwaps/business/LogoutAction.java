package fr.dwaps.business;

import javax.servlet.http.HttpServletRequest;

import fr.dwaps.web.util.AbstractAction;
import fr.dwaps.web.util.Constants;

public class LogoutAction extends AbstractAction {
	private static final String JSP_PAGE = Constants.JSP_LOGOUT_NAME;
	
	@Override
	public String executeAction(HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		return JSP_PAGE;
	}

}
