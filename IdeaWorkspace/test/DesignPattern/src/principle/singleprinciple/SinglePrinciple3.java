package principle.singleprinciple;

/**
 * @Time: 2019/8/1 15:39
 * @Author: bxx
 * @Description: 方法级别单一职责
 */
public class SinglePrinciple3 {

    public static void main(String[] args) {
        Vehicle2 vehicle2 = new Vehicle2();
        vehicle2.roadRun("汽车");
        vehicle2.skyRun("飞机");
        vehicle2.seaRun("轮船");

    }

}

class Vehicle2 {

    public void roadRun(String name) {
        System.out.println(name + "在路上跑");
    }

    public void skyRun(String name) {
        System.out.println(name + "在天上飞");
    }

    public void seaRun(String name) {
        System.out.println(name + "在海中行");
    }

}
