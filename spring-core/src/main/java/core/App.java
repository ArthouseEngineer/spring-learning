package core;

import core.entities.Client;
import core.loggers.Event;
import core.loggers.EventLogger;
import core.loggers.EventType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class App {

    private EventLogger defaultEventLogger;
    private Map<EventType, EventLogger> loggersMap;

    private Client client;


    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        App app = applicationContext.getBean(App.class);

        app.logEvents(applicationContext);
    }

    public App(EventLogger defaultEventLogger, Map<EventType, EventLogger> loggersMap, Client client) {
        this.defaultEventLogger = defaultEventLogger;
        this.loggersMap = loggersMap;
        this.client = client;
    }

    public void logEvent(EventType eventType, Event event, String msg) {
        String message = msg.replaceAll(String.valueOf(client.getId()), client.getFullName());
        event.setMsg(message);

        EventLogger logger = loggersMap.get(eventType);
        if (logger == null) {
            logger = defaultEventLogger;
        }
        logger.logEvent(event);
    }

    private void logEvents(ApplicationContext context) {

        Event event = context.getBean(Event.class);

        logEvent(EventType.INFO, event, "some event for user 1");

        event = context.getBean(Event.class);

        logEvent(EventType.ERROR, event, "some event for user 2");
    }
}
