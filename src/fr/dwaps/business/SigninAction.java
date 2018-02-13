package fr.dwaps.business;

import static fr.dwaps.web.util.Constants.TITLE_SIGNIN_PAGE;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import fr.dwaps.model.beans.Address;
import fr.dwaps.model.beans.User;
import fr.dwaps.model.dao.DAOFactory;
import fr.dwaps.web.util.AbstractAction;
import fr.dwaps.web.util.Constants;

public class SigninAction extends AbstractAction {
	private static final String JSP_PAGE = Constants.JSP_SIGNIN_NAME;
	private static final String TITLE = TITLE_SIGNIN_PAGE;
	
	@Override
	public String executeAction(HttpServletRequest request) {
		request.setAttribute("title", TITLE);
		
		boolean postMethod = request.getMethod().equals("POST");
		
		if (postMethod) {
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String pseudo = request.getParameter("pseudo");
			String password = request.getParameter("password");
			String birthdayStr = request.getParameter("birthday");
			String street = request.getParameter("street");
			String zip = request.getParameter("zip");
			String city = request.getParameter("city");
			
			try {
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date birthday = formatter.parse(birthdayStr);
				User user = new User(firstname, lastname, birthday, pseudo, password);
				user.setAddress(new Address(street, zip, city));
				
				DAOFactory.getUserDAO().create(user);
				request.getSession().setAttribute("user", user);
				request.setAttribute("redirect", true);
			}
			catch (Exception e) { e.printStackTrace(); }
		}
		
		return JSP_PAGE;
	}

}
