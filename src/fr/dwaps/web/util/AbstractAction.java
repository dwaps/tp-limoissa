package fr.dwaps.web.util;

import javax.servlet.http.HttpServletRequest;

public abstract class AbstractAction {
	public abstract String executeAction(HttpServletRequest request);
}