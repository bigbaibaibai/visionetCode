package xyz.thishome.onling_ksxt.pojo;

public class ChoiseVo extends Choise {

    //学生答案
    private String stuAnswer;

    public String getStuAnswer() {
        return stuAnswer;
    }

    public void setStuAnswer(String stuAnswer) {
        this.stuAnswer = stuAnswer;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }

    //是否正确
    private boolean isTrue;

}
