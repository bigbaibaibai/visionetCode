package singleton;

/**
 * @Time: 2019/7/25 17:36
 * @Author: bxx
 * @Description:  内部类单例
 */
public class InnerClassSinleton {

    private InnerClassSinleton(){}



    public static InnerClassSinleton getSinleton(){
        return InnerClass.INNER_CLASS_SINLETON;
    }

    static class InnerClass{
        private static final InnerClassSinleton INNER_CLASS_SINLETON = new InnerClassSinleton();
    }
}
