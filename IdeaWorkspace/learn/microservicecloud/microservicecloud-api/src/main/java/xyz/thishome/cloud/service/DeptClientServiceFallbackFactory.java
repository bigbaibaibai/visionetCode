package xyz.thishome.cloud.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import xyz.thishome.cloud.entities.Dept;

import java.util.List;

@Component   //千万别忘记加！！！
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable throwable) {

        //此对象用于对应方法的熔断处理
        return new DeptClientService() {
            @Override
            public Dept get(long id) {
                return new Dept().setDeptno(id).setDname("部门信息不存在").setDb_source("不存在数据库中");
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public boolean add(Dept dept) {
                return false;
            }
        };
    }
}
