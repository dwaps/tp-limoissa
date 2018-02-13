package fr.dwaps.web.filters;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import fr.dwaps.web.util.Constants;
import fr.dwaps.web.util.NavigationTabs;

@WebFilter(
	servletNames={
		Constants.FRONT_SERVLET_NAME,
		Constants.BACK_SERVLET_NAME },
	dispatcherTypes=DispatcherType.REQUEST)
public class InitNavigationTabsFilter implements Filter {
	
	public void init(FilterConfig fConfig) throws ServletException {
		String ctxPath = fConfig.getServletContext().getContextPath();
		for (NavigationTabs tab : NavigationTabs.values()) {
			tab.setUrlWithCtxPath(ctxPath);
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String uri = ((HttpServletRequest) request).getRequestURI();

		for (NavigationTabs tab : NavigationTabs.values()) {
			tab.setActive(false);
			if (tab.getUrl().equals(uri)) {
				tab.setActive(true);
			}
		}
		request.setAttribute("tabs", NavigationTabs.values());
		
		chain.doFilter(request, response);
	}

	public void destroy() {}
}
