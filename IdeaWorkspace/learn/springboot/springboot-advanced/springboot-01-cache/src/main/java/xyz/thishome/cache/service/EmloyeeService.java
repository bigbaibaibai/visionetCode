package xyz.thishome.cache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;
import xyz.thishome.cache.bean.Employee;
import xyz.thishome.cache.mapper.EmployeeMapper;

@Service
public class EmloyeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

//    @Cacheable(value = {"emp"}, unless = "#result==null")
//    public Employee getEmp(Integer id) {
//        System.out.println("执行查询方法");
//        return employeeMapper.getEmpForId(id);
//    }

    @CachePut(value = {"emp"}, key = "#employee.id")
    public Employee updateEmp(Employee employee) {
        employeeMapper.updateEmp(employee);
        return employee;
    }

    @Qualifier("redisCacheManager")//如果有多个缓存管理器，可以通过设置该注解属性指定需要注入哪个组件
    @Autowired     //也可以通过属性名
    private RedisCacheManager redisCacheManager;

    public Employee getEmp(Integer id) {
        Employee emp = employeeMapper.getEmpForId(id);
        //获取缓存对象
        Cache cache = redisCacheManager.getCache("emp");
        //添加到缓存
        cache.put(emp.getdId(), emp);
        return emp;
    }

}
