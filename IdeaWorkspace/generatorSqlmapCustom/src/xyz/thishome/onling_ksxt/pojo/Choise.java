package xyz.thishome.onling_ksxt.pojo;

import java.util.Date;

public class Choise {
    private Integer id;

    private String title;

    private String subject;

    private String answer;

    private String type;

    private Date creatTime;

    private Date updateTime;

    private String choiseA;

    private String choiseB;

    private String choiseC;

    private String choiseD;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getChoiseA() {
        return choiseA;
    }

    public void setChoiseA(String choiseA) {
        this.choiseA = choiseA == null ? null : choiseA.trim();
    }

    public String getChoiseB() {
        return choiseB;
    }

    public void setChoiseB(String choiseB) {
        this.choiseB = choiseB == null ? null : choiseB.trim();
    }

    public String getChoiseC() {
        return choiseC;
    }

    public void setChoiseC(String choiseC) {
        this.choiseC = choiseC == null ? null : choiseC.trim();
    }

    public String getChoiseD() {
        return choiseD;
    }

    public void setChoiseD(String choiseD) {
        this.choiseD = choiseD == null ? null : choiseD.trim();
    }
}