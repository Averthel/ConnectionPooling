package pl.ave.jdbc.listener;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import pl.ave.jdbc.db.DbUtil;

@WebListener
public class DbInitListener implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Context initialized");
		try {
			DbUtil.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		DbUtil.getInstance().close();
		System.out.println("Context Destroyed");
	}

}
