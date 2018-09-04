package loggers;

import com.spring.core.loggers.FileEventLogger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileEventLoggerTest {

    private File file;

    @Before
    public void createFile() throws IOException {
        this.file = File.createTempFile("test","FileEventLogger");
    }

    @After
    public void removeFile() {
        this.file.delete();
    }

    @Test
    public void testInit(){
        FileEventLogger logger = new FileEventLogger(file.getAbsolutePath());
    }

    // Проверим невозможность записи в файл
    @Test(expected = IllegalArgumentException.class)
    public void testInitFail(){
        file.setReadOnly();
        FileEventLogger logger = new FileEventLogger(file.getAbsolutePath());
        logger.init();
    }

}