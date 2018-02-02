package fr.dwaps.web.util;

public enum NavigationTabs {
	HOME("Accueil", "/home"),
	BOOKS("Liste des livres", "/books"),
	CONTACT("Contact", "/contact");
	
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