package xyz.thishome.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.thishome.springboot.entities.Department;
import xyz.thishome.springboot.mapper.DepartmentMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DepatmentController {

    @Autowired
    DepartmentMapper departmentMapper;

    @RequestMapping("/dep/{id}")
    public Map<String ,Object> get(@PathVariable Integer id){
        Map<String, Object> map = new HashMap<>();
        Department depForId = departmentMapper.getDepForId(id);
        map.put("dep",depForId);
        return map;
    }

    @RequestMapping("/dep")
    public Map<String ,Object> insert(Department department){
        Map<String, Object> map=new HashMap<>();
        departmentMapper.insertDep(department);
        map.put("dep",department);
        return map;
    }

    @RequestMapping("/deps")
    public Map<String ,Object> getAll(){
        Map<String, Object> map = new HashMap<>();
        List<Department> allDeps = departmentMapper.getAllDeps();
        map.put("dep",allDeps);
        return map;
    }


}
