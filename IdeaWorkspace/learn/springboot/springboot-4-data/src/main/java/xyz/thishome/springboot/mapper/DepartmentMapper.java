package xyz.thishome.springboot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import xyz.thishome.springboot.entities.Department;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDepForId(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(department_name) value(#{departmentName})")
    public Integer insertDep(Department department);

    @Select("select * from department")
    public List<Department> getAllDeps();

}
