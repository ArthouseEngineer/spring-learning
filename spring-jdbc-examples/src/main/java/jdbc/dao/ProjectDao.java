package jdbc.dao;

public interface ProjectDao {
    void createProject(Integer developerId, String projectName, String companyName);
}
