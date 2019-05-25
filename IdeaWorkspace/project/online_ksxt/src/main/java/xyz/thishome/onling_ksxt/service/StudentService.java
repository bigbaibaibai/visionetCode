package xyz.thishome.onling_ksxt.service;

import xyz.thishome.onling_ksxt.pojo.Student;

import java.util.List;

public interface StudentService {

    /**
     * 登录使用
     *
     * @param Id
     * @param password
     * @return
     */
    Student getStuByLogin(Integer Id, String password);

    /**
     * 通过学号获取学生信息
     *
     * @param StuId
     * @return
     */
    Student getStuById(Integer stuId);

    /**
     * 添加学生到数据库
     *
     * @param student
     */
    void addStu(Student student);

    /**
     * 通过学号删除学生
     *
     * @param stuId
     */
    void delStu(Integer stuId);


    /**
     * 查询所有的学生信息
     *
     * @return
     */
    List<Student> getList();

}
