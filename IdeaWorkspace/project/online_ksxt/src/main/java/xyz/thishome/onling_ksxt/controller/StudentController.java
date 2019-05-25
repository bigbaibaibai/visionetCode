package xyz.thishome.onling_ksxt.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.thishome.onling_ksxt.pojo.Student;
import xyz.thishome.onling_ksxt.service.StudentService;
import xyz.thishome.onling_ksxt.util.KsxtMsg;
import xyz.thishome.onling_ksxt.util.MD5Utils;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/stu")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //登录
    @PostMapping("/login")
    public KsxtMsg login(@RequestParam("stuId") Integer stuId, @RequestParam("password") String password
            , HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        //判空
        if (stuId == null || StringUtils.isBlank(password)) {
            return KsxtMsg.bulid("学号和密码不能为空！");
        }
        try {
            Student stuById = studentService.getStuByLogin(stuId, password);
            if (stuById != null) {
                stuById.setPassword("");
                return KsxtMsg.success(stuById);
            } else {
                return KsxtMsg.bulid("学号或密码输入错误！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return KsxtMsg.bulid("程序执行异常：" + e.getMessage());
        }
    }

    //添加用户
    @PostMapping("/add")
    public KsxtMsg addUser(Student student, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        //判断是否为空
        //判空
        if (student == null || student.getStuId() == null || StringUtils.isBlank(student.getPassword())) {
            return KsxtMsg.bulid("学号和密码不能为空！");
        }
        try {
            //判断学号是否存在
            Student stuById = studentService.getStuById(student.getStuId());
            if (stuById != null) {
                return KsxtMsg.bulid("学号已存在！");
            }
            //添加学生到数据库
            studentService.addStu(student);
            return KsxtMsg.success(student);
        } catch (Exception e) {
            e.printStackTrace();
            return KsxtMsg.bulid("程序执行异常：" + e.getMessage());
        }
    }
//
//    //修改用户
//    @PostMapping("/update")
//    public KsxtMsg update(Student student) {
//
//        //判断是否为空
//
//        //如果有密码，进行Md5加密
//
//        //更新到数据库
//
//        return KsxtMsg.success();
//    }
//
//
//    //删除用户
//    @PostMapping("/delete")
//    public KsxtMsg deleteStudent(@RequestParam("xh") Integer xh/*学号*/) {
//        //判断是否为空
//
//
//        return KsxtMsg.success();
//    }
//
//    //查询所有用户
//    @GetMapping("/getList")
//    public KsxtMsg getList() {
//
//
//        return KsxtMsg.success();
//    }
//
//    //根据学号查询用户
//    @PostMapping("/getForXh")
//    public KsxtMsg getStudentForXh(@RequestParam("xh") Integer xh) {
//
//
//        return KsxtMsg.success();
//    }
//
//    //根据学号查询用户试卷
//    @PostMapping("/getTest")
//    public KsxtMsg getTest(@RequestParam("xh") Integer xh) {
//
//        return KsxtMsg.success();
//    }


}
