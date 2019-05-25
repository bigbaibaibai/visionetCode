package xyz.thishome.onling_ksxt.pojo;

public class TestHistory {
    private Integer id;

    private Integer userId;

    private Integer grade;

    private String subject;

    private String textPaper;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public String getTextPaper() {
        return textPaper;
    }

    public void setTextPaper(String textPaper) {
        this.textPaper = textPaper == null ? null : textPaper.trim();
    }
}