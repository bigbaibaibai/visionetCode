package demo;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Time: 2019/5/28 10:10
 * @Author: bxx
 * @Description:
 */
public class DataTimeDemo {

    public static void main(String[] args) {
        try {
            Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-05-23 00:00:00");
            System.out.println(parse.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDate() {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, 1);
        Date onYearOld = calendar.getTime();
        long l = onYearOld.getTime() - date.getTime();
        System.out.println((int) (l / 1000 / 60 / 60 / 24));
    }


    @Test
    public void test(){

        List<String> phone = null;
        StringBuilder sb = new StringBuilder("insert into ");

        sb.toString();

    }
}
