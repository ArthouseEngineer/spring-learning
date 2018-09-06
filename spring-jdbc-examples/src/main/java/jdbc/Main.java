package jdbc;

import jdbc.dao.DeveloperDaoImpl;
import jdbc.dao.ProjectDaoImpl;
import jdbc.model.Developer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        DeveloperDaoImpl developerDao = applicationContext.getBean(DeveloperDaoImpl.class);

        ProjectDaoImpl projectDao = applicationContext.getBean(ProjectDaoImpl.class);

      /*  System.out.println("===============Creating new records to DB===============");
        developerDao.createDeveloper("Vladislav","Java middle",6);
        developerDao.createDeveloper("Andrey", "C# Developer", 2);
        developerDao.createDeveloper("Alina", "UI Designer", 3);*/

        System.out.println("======== Creating project's records ========");
        projectDao.createProject(1, "EFS", "SBT");
        projectDao.createProject(2, "God of war", "Santa Monica");

        System.out.println("======== Developers List ========");
        developerDao.listDevelopers().forEach(System.out::println);

        System.out.println("======== Developers in Project List ========");
        developerDao.listDeveloperProjects(1).forEach(System.out::println);
    }
}
