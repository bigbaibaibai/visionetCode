package xyz.thishome.onling_ksxt.pojo;

import java.util.ArrayList;
import java.util.List;

public class Paper {

    private Integer stuId;

    private List<ChoiseVo> choises = new ArrayList<>();

    private List<FillVo> fills = new ArrayList<>();

    private String subject;

    private String gread;

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public List<ChoiseVo> getChoises() {
        return choises;
    }

    public void setChoises(List<ChoiseVo> choises) {
        this.choises = choises;
    }

    public List<FillVo> getFills() {
        return fills;
    }

    public void setFills(List<FillVo> fills) {
        this.fills = fills;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getGread() {
        return gread;
    }

    public void setGread(String gread) {
        this.gread = gread;
    }
}
