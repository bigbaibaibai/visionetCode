package xyz.thishome.onling_ksxt.pojo;

public class FillVo extends FillOrQuestion {

    //学生答案
    private String stuAnswer;

    //是否正确
    private boolean isTrue;

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
}
