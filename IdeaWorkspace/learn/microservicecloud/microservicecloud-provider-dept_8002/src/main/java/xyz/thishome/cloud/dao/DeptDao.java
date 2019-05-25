package xyz.thishome.cloud.dao;

import xyz.thishome.cloud.entities.Dept;

import java.util.List;

public interface DeptDao {

    boolean addDept(Dept dept);

    Dept findById(Long id);

    List<Dept> findAll();

}
