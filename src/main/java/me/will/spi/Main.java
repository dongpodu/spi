package me.will.spi;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class Main {

    /**
     * 两个问题：
     * 1、未显示调用Class.forName()，如何将驱动注册到driverManager中的？
     *        答：JDBC 2.0中的drivermanager通过spi服务发现机制找到相关驱动实现
     * 2、DriverManger是由BootStrapClassLoader加载的，而驱动实现是引入的jar包，是无法被BootStrapClassLoader加载的，如何能加载到驱动实现呢？
     *        答：在线程中设置AppClassLoader加载器，将加载驱动实现的任务委派给AppClassLoader即可（这就是spi加载外部类机制）
     * @param args
     */
    public static void main(String[] args) {
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            System.out.println(driver.getClass() + "------" + driver.getClass().getClassLoader());
        }
        System.out.println(DriverManager.class.getClassLoader());
    }
}
