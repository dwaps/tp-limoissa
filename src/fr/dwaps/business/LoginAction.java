package fr.dwaps.business;

import static fr.dwaps.web.util.Constants.TITLE_BOOK_EDIT_PAGE;

import javax.servlet.http.HttpServletRequest;

import fr.dwaps.model.beans.User;
import fr.dwaps.model.dao.DAOFactory;
import fr.dwaps.model.dao.UserDAO;
import fr.dwaps.web.util.AbstractAction;
import fr.dwaps.web.util.Constants;

public class LoginAction extends AbstractAction {
	private static final String JSP_PAGE = Constants.JSP_LOGIN_NAME;
	private static final String TITLE = TITLE_BOOK_EDIT_PAGE;
	
	@Override
	public String executeAction(HttpServletRequest request) {
		request.setAttribute("title", TITLE);
		boolean postMethod = request.getMethod().equals("POST");
		
		if (postMethod) {
			String pseudo = request.getParameter("pseudo");
			String password = request.getParameter("password");
			
			try {
				UserDAO userDao = (UserDAO) DAOFactory.getUserDAO();
				User user = userDao.findByPseudo(pseudo);

				if (user.checkPassword(password)) {
					request.getSession().setAttribute("user", user);
					request.setAttribute("redirect", true);
				}
			}
			catch (Exception e) { e.printStackTrace(); }
		}
		
		return JSP_PAGE;
	}

}