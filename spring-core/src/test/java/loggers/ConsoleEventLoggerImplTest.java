package loggers;

import core.loggers.ConsoleEventLoggerImpl;
import core.loggers.Event;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ConsoleEventLoggerImplTest {

    private static final String MESSAGE = "Test console logger";
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private ConfigurableApplicationContext context;

    @Before
    public void setOutContent() {
        System.setOut(new PrintStream(outContent));
        context = new ClassPathXmlApplicationContext("spring.xml");
    }

    @After
    public void cleanStreams() {
        System.setOut(null);
        context.close();
    }

    @Test
    public void logEvent() {

        ConsoleEventLoggerImpl consoleEventLogger = context.getBean(ConsoleEventLoggerImpl.class);
        Event event = context.getBean(Event.class);

        event.setMsg(MESSAGE);

        consoleEventLogger.logEvent(event);

        assertTrue(outContent.toString().contains(event.toString()));

        assertEquals(event.toString().trim(), outContent.toString().trim());
    }
}