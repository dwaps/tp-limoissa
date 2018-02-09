package fr.dwaps.business;

import javax.servlet.http.HttpServletRequest;

import fr.dwaps.model.beans.Book;
import fr.dwaps.model.dao.DAOFactory;
import fr.dwaps.web.util.AbstractAction;
import static fr.dwaps.web.util.Constants.*;

public class EditBookAction extends AbstractAction {
	private static final String JSP_PAGE = JSP_BOOK_FORM_NAME;
	private static final String TITLE = TITLE_BOOK_EDIT_PAGE;
	
	@Override
	public String executeAction(HttpServletRequest request) {
		request.setAttribute("title", TITLE);
		boolean postMethod = request.getMethod().equals("POST");
		
		Book book = null;
		String idStr = request.getParameter(BOOK_ID);
		
		try {
			try {
				int id = Integer.parseInt(idStr);
				book = DAOFactory.getBookDAO().find(id);
			} catch (Exception e) { request.setAttribute("reload", true); }
			
			if (!postMethod) {
				request.setAttribute("book", book);
			} else {
				System.out.println("EditBook postMethod...");
				String title = request.getParameter(BOOK_TITLE);
				String description = request.getParameter(BOOK_DESCRIPTION);
				String author = request.getParameter(BOOK_AUTHOR);
				String img = request.getParameter(BOOK_IMG);
				String priceStr = request.getParameter(BOOK_PRICE);
				String availableStr = request.getParameter(BOOK_AVAILABLE);

				priceStr = priceStr.replace(",", ".");
				double price = Double.parseDouble(priceStr);
				boolean available = (availableStr != null) ? true : false;

				book.setTitle(title);
				book.setDescription(description);
				book.setAuthor(author);
				book.setImg(img);
				book.setPrice(price);
				book.setAvailable(available);
				DAOFactory.getBookDAO().update(book);
				
				request.getSession().setAttribute(INFO_ATTR, INFO_BOOK_UPDATED_OK);
				request.setAttribute("redirectUrl", ADMIN_BOOKS_LIST_URL);
			}
		}
		catch (Exception e) {
			if (postMethod) {
				request.getSession().setAttribute(INFO_ATTR, INFO_BOOK_UPDATED_FAIL);
				request.setAttribute("redirectUrl", ADMIN_BOOKS_EDIT_URL);
			}
			e.printStackTrace();
		}
		
		return JSP_PAGE;
	}

}
