package xyz.thishome.cloud.service;

import xyz.thishome.cloud.entities.Dept;

import java.util.List;

public interface DeptService {

    boolean add(Dept dept);
    Dept    get(Long id);
    List<Dept> list();

}
