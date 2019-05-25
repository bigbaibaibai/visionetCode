package xyz.thishome.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xyz.thishome.bean.MathCalculator;
import xyz.thishome.config.MainConfigOfAOP;

public class TestAOP {

    private static int count;

    @Test
    public void testAOP() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
        MathCalculator mathCalculator = context.getBean(MathCalculator.class);
        int dev = mathCalculator.dev(4, 0);
        System.out.println(dev);
    }

    @Test
    public void str789Test() {
        StringBuilder sb = new StringBuilder();
        appendStr(sb, new StringBuilder("1234"), new StringBuilder());
        System.out.println(sb);  //789 798 879 897 978 987
        System.out.println(count);
    }

    private void appendStr(StringBuilder sb, StringBuilder num, StringBuilder onceStr) {
        //遍历字符串中所有的字符
        for (int i = 0; i < num.length(); i++) {
            //将当前遍历字符追加到本次需要追加的字符串中
            onceStr.append(num.charAt(i));
            //如果num的长度为1，证明本次需要追加到总字符串的字符串已经完整
            if (1 == num.length()) {
                //把本次的完整字符串追加到sb总字符串中，加上空格
                sb.append(onceStr).append(" ");
                //删除最后一个字符
                onceStr.deleteCharAt(onceStr.length()-1);
                count++;
                //本轮结束
                return;
            }
            //如果长度不为1证明后续还有需要追加的字符，递归本方法，传入总字符串，删除本次追加的字符后的字符串，本次需要追加的字符未完整版
            appendStr(sb, new StringBuilder(num).deleteCharAt(i), onceStr);
            //删除本次追加的字符串，进行下一轮
            onceStr.deleteCharAt(onceStr.length()-1);
        }
    }

}
