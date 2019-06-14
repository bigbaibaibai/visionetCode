package test;

import org.junit.Test;

import java.io.FileReader;

public class TestEncoding {
    @Test
    public void testEncoding() throws Exception{
        FileReader fileReader = new FileReader("C:\\Users\\bai\\Desktop\\工作记录.txt");
        char[] chars = new char[10000];
        fileReader.read(chars);
        String s = new String(chars);
        System.out.println(s);
        byte[] gbks = s.getBytes("windows-1252");
        String s1 = new String(gbks, "gbk");
        System.out.println(s1);

    }

}
