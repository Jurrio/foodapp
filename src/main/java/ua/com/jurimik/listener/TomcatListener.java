package ua.com.jurimik.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import ua.com.jurimik.dao.SafeLoader;

public class TomcatListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		SafeLoader.unmarshall();
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		SafeLoader.marshall();
	}

}
