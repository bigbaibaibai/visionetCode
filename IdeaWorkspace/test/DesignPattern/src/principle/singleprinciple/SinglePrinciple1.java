package principle.singleprinciple;

/**
 * @Time: 2019/8/1 14:43
 * @Author: bxx
 * @Description: 违反单一原则的案例
 */
public class SinglePrinciple1 {
    public static void main(String[] args) {
        Vehicle1 vehicle1 = new Vehicle1();
        vehicle1.run("汽车");
        vehicle1.run("飞机");
        vehicle1.run("轮船");
    }
}

/**
 * @Time: 2019/8/1 14:44
 * @Author: bxx
 * @Description: 交通工具 类
 */
class Vehicle1 {
    /**
     * 这里的run方法太泛泛，并没有遵循单一职责的原则，如果是飞机或者轮船就会出问题
     * @param name
     */
    public void run(String name){
        System.out.println(name + "在路上跑");
    }
}
