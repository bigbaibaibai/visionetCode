package principle.singleprinciple;

/**
 * @Time: 2019/8/1 15:38
 * @Author: bxx
 * @Description:  类级别单一职责
 */
public class SinglePrinciple2 {
    public static void main(String[] args) {
        VehicleRoad vehicleRoad = new VehicleRoad();
        vehicleRoad.run("汽车");

        VehicleSky vehicleSky = new VehicleSky();
        vehicleSky.run("飞机");

        VehicleSea vehicleSea = new VehicleSea();
        vehicleSea.run("轮船");
    }
}

/**
 * @Time: 2019/8/1 14:44
 * @Author: bxx
 * @Description: 陆地交通工具 类
 */
class VehicleRoad {
    public void run(String name) {
        System.out.println(name + "在路上跑");
    }
}

/**
 * @Time: 2019/8/1 14:44
 * @Author: bxx
 * @Description: 交通空中工具 类
 */
class VehicleSky {
    public void run(String name) {
        System.out.println(name + "在天上飞");
    }
}

/**
 * @Time: 2019/8/1 14:44
 * @Author: bxx
 * @Description: 海洋交通工具 类
 */
class VehicleSea {
    public void run(String name) {
        System.out.println(name + "在海中行");
    }
}


