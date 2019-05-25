package xyz.thishome.onling_ksxt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xyz.thishome.onling_ksxt.mapper.StudentMapper;
import xyz.thishome.onling_ksxt.pojo.Student;
import xyz.thishome.onling_ksxt.pojo.StudentExample;
import xyz.thishome.onling_ksxt.service.StudentService;
import xyz.thishome.onling_ksxt.util.MD5Utils;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student getStuByLogin(Integer id, String password) {
        try {
            password = MD5Utils.getMD5Str(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        criteria.andStuIdEqualTo(id);
        criteria.andPasswordEqualTo(password);
        List<Student> students = studentMapper.selectByExample(example);
        if (students != null && students.size() > 0) {
            return students.get(0);
        }
        return null;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Student getStuById(Integer stuId) {
        Student student = studentMapper.selectByPrimaryKey(stuId);
        if (student != null) {
            student.setPassword("");
            return student;
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addStu(Student student) {
        try {
            student.setPassword(MD5Utils.getMD5Str(student.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        studentMapper.insertSelective(student);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delStu(Integer stuId) {
        studentMapper.deleteByPrimaryKey(stuId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Student> getList() {
        List<Student> students = studentMapper.selectByExample(null);
        try {
            for (Student student : students) {
                student.setPassword("");
                return students;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
