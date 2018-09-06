package jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class ProjectDaoImpl implements ProjectDao {

    private JdbcTemplate jdbcTemplate;

    public ProjectDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createProject(Integer developerId, String projectName, String companyName) {
        String SQL = "INSERT INTO PROJECTS (DEVELOPERS_ID, NAME, COMPANY) VALUES (?,?,?)";
        jdbcTemplate.update(SQL,developerId,projectName,companyName);
        System.out.println("Project record successful added to DB");
    }
}
