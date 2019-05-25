package xyz.thishome.springboot.entities;

public class Department {

    private Integer id;
    private String departmentName;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }


    public void setId(Integer id) {

        this.id = id;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getId() {

        return id;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}
