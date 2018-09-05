package jdbc.dao;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

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
    public void testFindDeveloper() {
        DeveloperDaoImpl developerDao = context.getBean(DeveloperDaoImpl.class);

        List developersList = developerDao.listDevelopers();
        Assert.assertNotNull(developersList);
        Assert.assertTrue(developersList.size() == 3);
    }

}