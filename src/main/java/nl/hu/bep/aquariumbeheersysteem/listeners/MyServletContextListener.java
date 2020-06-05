package nl.hu.bep.aquariumbeheersysteem.listeners;

import nl.hu.bep.aquariumbeheersysteem.model.Eigenaar;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce){
        System.out.println("systeem aan het opstarten");
        new Eigenaar("fars", "fars");
        new Eigenaar("abeer", "abeer").setAdmin();

    }
}
