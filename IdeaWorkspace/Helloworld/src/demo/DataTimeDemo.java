package demo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataTimeDemo {

    public static void main(String[] args) {
        try {

            Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-05-23 00:00:00");
            System.out.println(parse.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
