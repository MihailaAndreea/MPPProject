package client;

import client.ui.ClientConsole;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by radu.
 */

public class ClientApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("client.config");
        ClientConsole console = context.getBean(ClientConsole.class);
        console.runConsole();
        System.out.println("bye ");
    }
}
