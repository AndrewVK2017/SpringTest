package com.andrew.springtest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    Client client;
    EventLogger eventLogger;

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public static void main(String[] args) {
        //App app = new App();
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = ctx.getBean("app", App.class);

        app.logEvent("Some event for user 1");
        app.logEvent("Some event for user 2");


    }

    private void logEvent(String msg){
        String message = msg.replaceAll(client.getId(), client.getFullName());
        eventLogger.logEvent();
    }
}
