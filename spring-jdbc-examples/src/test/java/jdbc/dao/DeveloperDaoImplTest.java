package jdbc.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


import static org.junit.Assert.*;

public class DeveloperDaoImplTest {

    private ConfigurableApplicationContext context;

    @Before
    public void createContext() {
        context = new ClassPathXmlApplicationContext("spring.xml");
    }

    @After
    public void closeContext() {
        context.close();
    }

    @Test
    public void testSelectDeveloper() {
        DeveloperDaoImpl developerDao = context.getBean(DeveloperDaoImpl.class);

        List developersList = developerDao.listDevelopers();
        assertNotNull(developersList);
        assertTrue(developersList.size() == 3);
        assertEquals(developersList.get(0).toString().trim(),developerDao.getDeveloperById(1).toString().trim());
    }

}