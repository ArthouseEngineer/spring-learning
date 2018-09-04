package jdbc.dao;

import java.util.List;

public interface DeveloperDao {

    void createDeveloper(String name, String speciality, Integer experience);

    Object getDeveloperById(Integer id);

    List listDevelopers();

    void removeDeveloper(Integer id);

    void updateDeveloper(Integer id, String name, String speciality, Integer experience);
}
