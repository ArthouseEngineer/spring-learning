package jdbc.model;

public class Project {

    private Integer developerId;
    private String projectName;
    private String companyName;

    public Integer getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(Integer developerId) {
        this.developerId = developerId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "ProjectDao{" +
                "developerId=" + developerId +
                ", projectName='" + projectName + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
