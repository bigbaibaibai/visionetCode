package regular;

import org.junit.Test;

public class TestRegularExpression {

    @Test
    public void testEmail(){
        String str = "ommy";
        System.out.println(str.matches("\\w{1,15}"));

    }
}
