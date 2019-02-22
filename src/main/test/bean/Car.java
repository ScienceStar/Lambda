package bean;

import service.Supplier;

/**
 * @author lxc
 * @Title: Car
 * @ProjectName lambdaTest
 * @Description: TODO
 * @date 2019/2/21 14:03
 */
public class Car {

    public String carColor;
    public String carPrice;

    // 通过Supplier获取Car实例
    public static Car create(Supplier<Car> supplier) {
        return supplier.getEntity();
    }

    // 静态方法，一个入参Car对象
    public static void collide(final Car car) {
        System.out.println("Collide " + car.toString());
    }

    // 一个入参Car
    public void follow(final Car car) {
        System.out.println("Following car " + car.toString());
    }

    // 不带入参
    public void repair(String str) {
        System.out.println("Repaired car " + this.toString()+str);
    }

    public void repair2() {
        System.out.println("Repaired car " + this.toString());
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(String carPrice) {
        this.carPrice = carPrice;
    }
}
