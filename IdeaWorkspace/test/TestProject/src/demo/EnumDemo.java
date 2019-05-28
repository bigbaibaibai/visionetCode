package demo;

/**
 * @Time: 2019/5/28 13:35
 * @Author: bxx
 * @Description:
 */
public enum EnumDemo{
    /**
     *
     */
    First{
        public void invoke() {
            System.out.println("first invoke");
        }
    },
    sec{
        public void invoke() {
            System.out.println("sec invoke");
            seHello();
        }
    };

    public void seHello(){

    }

}
