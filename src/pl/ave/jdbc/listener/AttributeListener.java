package pl.ave.jdbc.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class AttributeListener
        implements HttpSessionAttributeListener, ServletContextAttributeListener, ServletRequestAttributeListener {

    public void attributeAdded(ServletContextAttributeEvent scae) {
        // TODO Auto-generated method stub
    }

    public void attributeRemoved(ServletContextAttributeEvent scae) {
        // TODO Auto-generated method stub
    }

    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.println("Request Attribute removed " + srae.getName());
    }

    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("Request Attribute added " + srae.getName());
    }

    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println("Request Attribute replaced " + srae.getName());
    }

    public void attributeAdded(HttpSessionBindingEvent se) {
        // TODO Auto-generated method stub
    }

    public void attributeRemoved(HttpSessionBindingEvent se) {
        // TODO Auto-generated method stub
    }

    public void attributeReplaced(HttpSessionBindingEvent se) {
        // TODO Auto-generated method stub
    }

    public void attributeReplaced(ServletContextAttributeEvent scae) {
        // TODO Auto-generated method stub
    }
}
