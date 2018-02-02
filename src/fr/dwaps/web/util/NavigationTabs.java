package fr.dwaps.web.util;

import static fr.dwaps.web.util.Constants.*;

public enum NavigationTabs {
	HOME(HOME_TAB_LABEL, HOME_TAB_URL),
	BOOKS(BOOKS_TAB_LABEL, BOOKS_TAB_URL),
	CONTACT(CONTACT_TAB_LABEL, CONTACT_TAB_URL);
	
	private String label;
	private String url;
	private boolean active;
	
	private NavigationTabs(String label, String url) {
		this.label = label;
		this.url = url;
	}
	
	public String getLabel() { return label; }
	public String getUrl() { return url; }
	public boolean isActive() { return active; }
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public void setUrlWithCtxPath(String ctxPath) {
		this.url = ctxPath + url;
	}
}