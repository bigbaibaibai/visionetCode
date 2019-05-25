package xyz.thishome.cache.mapper;

import org.apache.ibatis.annotations.*;
import xyz.thishome.cache.bean.Employee;

@Mapper
public interface EmployeeMapper {

    /**
     * 通过id查询员工
     * @param id
     * @return
     */
    @Select("SELECT * FROM employee WHERE id = #{id}")
    public Employee getEmpForId(Integer id);

    /**
     * 根据ID更新员工
     * @param employee
     */
    @Update("UPDATE employee set lastName = #{lastName},email = #{email},gender = #{gender},d_id = ${dId} WHERE id = #{id}")
    public void updateEmp(Employee employee);

    /**
     * 插入一个员工
     */
    @Insert("INSERT INTO employee(lastName,email,gender,d_id) value(#{lastName},#{email},#{gender},#{dId})")
    public void insertEmp(Employee employee);

    /**
     * 根据员工ID删除员工
     * @param id
     */
    @Delete("DELETE FROM employee WHERE id = #{id}")
    public void deleteEmpForId(Integer id);

}
