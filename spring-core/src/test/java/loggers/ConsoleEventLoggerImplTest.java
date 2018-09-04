package loggers;

import core.loggers.ConsoleEventLoggerImpl;
import core.loggers.Event;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ConsoleEventLoggerImplTest {

    private static final String MESSAGE = "Test console logger";
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setOutContent(){
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanStreams(){
        System.setOut(null);
    }

    @Test
    public void logEvent() {
        ConsoleEventLoggerImpl consoleEventLogger = new ConsoleEventLoggerImpl();
        Event event = new Event(new Date(),DateFormat.getDateInstance());
        event.setMsg(MESSAGE);

        consoleEventLogger.logEvent(event);

        assertTrue(outContent.toString().contains(event.toString()));

        assertEquals(event.toString().trim(),outContent.toString().trim());
    }
}