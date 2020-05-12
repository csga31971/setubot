package xyz.csga.listener;

import xyz.csga.Poll;
import xyz.csga.Registry;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class InitListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        Registry.scanPackage("xyz.csga");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {

    }

}
