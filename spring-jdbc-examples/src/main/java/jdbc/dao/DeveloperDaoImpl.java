package jdbc.dao;

import jdbc.model.Developer;
import jdbc.util.DeveloperMapper;
import jdbc.util.ProjectMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class DeveloperDaoImpl implements DeveloperDao {

    private JdbcTemplate jdbcTemplate;

    public DeveloperDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createDeveloper(String name, String speciality, Integer experience) {
        String SQL = "INSERT INTO DEVELOPERS(name, specialty, experience) VALUES (?,?,?)";

        jdbcTemplate.update(SQL, name, speciality, experience);
        System.out.println("Developer successfully created.\nName: " + name + ";\nSpecilaty: " +
                speciality + ";\nExperience: " + experience + "\n");

    }

    @Override
    public Object getDeveloperById(Integer id) {
        String SQL = "SELECT * FROM DEVELOPERS WHERE id = ?";
        Developer developer = jdbcTemplate.queryForObject(SQL, new Object[]{id}, new DeveloperMapper());
        return developer;
    }

    @Override
    public List listDevelopers() {
        String SQL = "SELECT * FROM DEVELOPERS";
        return jdbcTemplate.query(SQL, new DeveloperMapper());
    }

    @Override
    public List listDeveloperProjects(Integer id) {
        String SQL = "SELECT * FROM PROJECTS WHERE DEVELOPERS_ID = " + id;
        return jdbcTemplate.query(SQL, new ProjectMapper());
    }

    @Override
    public void removeDeveloper(Integer id) {
        String SQL = "DELETE FROM DEVELOPERS WHERE id = ?";
        jdbcTemplate.update(SQL, id);
        System.out.println("Developer with id: " + id + " successfully removed");
    }

    @Override
    public void updateDeveloper(Integer id, String name, String speciality, Integer experience) {
        String SQL = "UPDATE DEVELOPERS SET name = ?, specialty = ?, experience = ? WHERE id = ?";
        jdbcTemplate.update(SQL, name, speciality, experience, id);
        System.out.println("Developer with id: " + id + " successfully updated.");
    }

    public void removeAll() {
        String SQL = "TRUNCATE DEVELOPERS";
        jdbcTemplate.update(SQL);
        System.out.println("Table was clean successful");
    }
}
