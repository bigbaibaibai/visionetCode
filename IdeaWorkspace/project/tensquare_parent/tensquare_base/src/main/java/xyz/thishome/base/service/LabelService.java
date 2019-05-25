package xyz.thishome.base.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.web.client.RestTemplateExchangeTagsProvider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import util.IdWorker;
import xyz.thishome.base.dao.LabelDao;
import xyz.thishome.base.pojo.Label;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class LabelService {

    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    public List<Label> findAll() {
        return labelDao.findAll();
    }

    public Label findById(String labelId) {
        return labelDao.findById(labelId).get();
    }

    public void save(Label label) {
        label.setId(idWorker.nextId() + "");
        labelDao.save(label);
    }

    public void update(Label label) {
        labelDao.save(label);
    }

    public void delete(String LabelId) {
        labelDao.deleteById(LabelId);
    }

    public Page<Label> findSearchPage(Label label, int page, int size) {
        //分页查询
        Pageable pageable = PageRequest.of(page, size);
        Page<Label> labelPage = labelDao.findAll(getSpecification(label), pageable);
        return labelPage;
    }

    public List<Label> findSearchList(Label label) {
        return labelDao.findAll(getSpecification(label));
    }

    private Specification<Label> getSpecification(Label label) {
        Specification<Label> specification = (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (!StringUtils.isBlank(label.getLabelname())) {
                //第一个参数，字段，第二个参数，值。as 最终生成SQL：where labelname like %小明%
                Predicate predicate = criteriaBuilder.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");
                predicates.add(predicate);
            }
            if (!StringUtils.isBlank(label.getState())) {
                Predicate predicate = criteriaBuilder.equal(root.get("state").as(String.class), label.getState());
                predicates.add(predicate);
            }

            Predicate[] array = new Predicate[predicates.size()];

            return criteriaBuilder.and(predicates.toArray(array));
        };
        return specification;
    }

}
