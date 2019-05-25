package xyz.thishome.base.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import xyz.thishome.base.pojo.Label;

public interface LabelDao extends JpaRepository<Label, String>/*注解第二个类型为ID类型*/,
        JpaSpecificationExecutor<Label> {
}
