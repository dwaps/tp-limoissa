package fr.dwaps.business;

import static fr.dwaps.web.util.Constants.ADMIN_BOOKS_CREATE_URL;
import static fr.dwaps.web.util.Constants.ADMIN_BOOKS_LIST_URL;
import static fr.dwaps.web.util.Constants.BOOK_AUTHOR;
import static fr.dwaps.web.util.Constants.BOOK_AVAILABLE;
import static fr.dwaps.web.util.Constants.BOOK_DESCRIPTION;
import static fr.dwaps.web.util.Constants.BOOK_IMG;
import static fr.dwaps.web.util.Constants.BOOK_PRICE;
import static fr.dwaps.web.util.Constants.BOOK_TITLE;
import static fr.dwaps.web.util.Constants.INFO_ATTR;
import static fr.dwaps.web.util.Constants.INFO_BOOK_CREATED_FAIL;
import static fr.dwaps.web.util.Constants.INFO_BOOK_CREATED_OK;

import javax.servlet.http.HttpServletRequest;

import fr.dwaps.model.beans.Book;
import fr.dwaps.service.BookService;
import fr.dwaps.web.util.AbstractAction;
import fr.dwaps.web.util.Constants;

public class CreateBookAction extends AbstractAction {
	private static final String JSP_PAGE = Constants.JSP_BOOK_FORM_NAME;
	private static final String TITLE = Constants.TITLE_BOOK_ADD_PAGE;
	
	@Override
	public String executeAction(HttpServletRequest request) {
		request.setAttribute("title", TITLE);
		
		if (request.getMethod().equals("POST")) {
			String title = request.getParameter(BOOK_TITLE);
			String description = request.getParameter(BOOK_DESCRIPTION);
			String author = request.getParameter(BOOK_AUTHOR);
			String img = request.getParameter(BOOK_IMG);
			String priceStr = request.getParameter(BOOK_PRICE);
			String availableStr = request.getParameter(BOOK_AVAILABLE);
			
			try {
				priceStr = priceStr.replace(",", ".");
				double price = Double.parseDouble(priceStr);
				boolean available = Boolean.parseBoolean(availableStr);
				Book book = new Book(title, description, author, img, price, available);
				BookService.create(book);
				request.getSession().setAttribute(INFO_ATTR, INFO_BOOK_CREATED_OK);
				request.setAttribute("redirectUrl", ADMIN_BOOKS_LIST_URL);
			}
			catch (Exception e) {
				request.getSession().setAttribute(INFO_ATTR, INFO_BOOK_CREATED_FAIL);
				request.setAttribute("redirectUrl", ADMIN_BOOKS_CREATE_URL);
				e.printStackTrace();
			}
		}
		
		return JSP_PAGE;
	}

}
