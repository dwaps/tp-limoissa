package fr.dwaps.web.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppListener implements ServletContextListener {
	private static final String PU = "pu_tp_library";
	
	private static EntityManagerFactory emf;
	
	public static EntityManagerFactory getEmf() { return emf; }

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		if (emf != null && emf.isOpen()) {
			emf.close();
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		emf = Persistence.createEntityManagerFactory(PU);
	}
}
