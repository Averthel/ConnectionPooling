package pl.ave.jdbc.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("Session created " + se.getSession().getId());
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("Session Destroyed");
	}
	
	//S�uchacz wywo�ywany przy tworzeniu nowej sesji, czyli np. odwo�aniu si� do aplikacji z innej przegl�dark
}
