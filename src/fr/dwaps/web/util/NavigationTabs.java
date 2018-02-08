package fr.dwaps.web.util;

import static fr.dwaps.web.util.Constants.*;

public enum NavigationTabs {
	// Frontend
	HOME(HOME_TAB_LABEL, HOME_TAB_URL, false),
	BOOKS(BOOKS_TAB_LABEL, BOOKS_TAB_URL, false),
	CONTACT(CONTACT_TAB_LABEL, CONTACT_TAB_URL, false),
	
	// Backend
	BOOKS_LIST(ADMIN_BOOKS_LIST_LABEL, ADMIN_BOOKS_LIST_URL, true),
	BOOKS_CREATE(ADMIN_BOOKS_CREATE_LABEL, ADMIN_BOOKS_CREATE_URL, true),
	BOOKS_EDIT(ADMIN_BOOKS_EDIT_LABEL, ADMIN_BOOKS_EDIT_URL, true);
	
	private String label;
	private String url;
	private boolean adminTab;
	private boolean active;
	
	private NavigationTabs(String label, String url, boolean adminTab) {
		this.label = label;
		this.url = url;
		this.adminTab = adminTab;
	}
	
	public String getLabel() { return label; }
	public String getUrl() { return url; }
	public boolean isAdminTab() { return adminTab; }
	public boolean isActive() { return active; }
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public void setUrlWithCtxPath(String ctxPath) {
		this.url = ctxPath + url;
	}
}