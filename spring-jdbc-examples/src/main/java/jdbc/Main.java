package jdbc;

import jdbc.dao.DeveloperDaoImpl;
import jdbc.model.Developer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        DeveloperDaoImpl developerDao = applicationContext.getBean(DeveloperDaoImpl.class);

      /*  System.out.println("===============Creating new records to DB===============");
        developerDao.createDeveloper("Vladislav","Java middle",6);
        developerDao.createDeveloper("Andrey", "C# Developer", 2);
        developerDao.createDeveloper("Alina", "UI Designer", 3);*/

        System.out.println("========Developers List========");
        developerDao.listDevelopers().stream().forEach(System.out::println);
    }
}
