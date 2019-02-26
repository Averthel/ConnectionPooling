package pl.ave.jdbc.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class ReqListener implements ServletRequestListener {
	
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("Request destroyed");
    }

    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("Request initialized");
    }
    
    //S�uchacz b�dzie wywo�ywany przy ka�dym ��daniu do aplikacji.

}
