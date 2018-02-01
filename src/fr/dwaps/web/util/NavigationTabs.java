package fr.dwaps.web.util;

public enum NavigationTabs {
	HOME("Accueil", "/home", false),
	BOOKS("Liste des livres", "/books", false),
	CONTACT("Contact", "/contact", false);
	
	private String label;
	private String url;
	private boolean active;
	
	private NavigationTabs(String label, String url, boolean active) {
		this.label = label;
		this.url = url;
		this.active = active;
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