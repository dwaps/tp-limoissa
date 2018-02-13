package fr.dwaps.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import fr.dwaps.web.util.ActionManager;
import fr.dwaps.web.util.Constants;

@WebFilter(
	urlPatterns= {
		Constants.SIGNIN_URL,
		Constants.LOGIN_URL,
		Constants.LOGOUT_URL })
public class CheckAccessFilter implements Filter {
	private ServletContext ctx;
	
	public void init(FilterConfig config) throws ServletException {
		ctx = config.getServletContext();
	}
	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String jspName = ActionManager
			.getAction((HttpServletRequest) request)
			.executeAction((HttpServletRequest) request);
		
		ctx.getNamedDispatcher(jspName).forward(request, response);
	}
}
