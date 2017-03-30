package com.istimaldar.transport;

import java.util.Objects;

abstract public class Transport {
    private Driver driver;
    String routeName;
    String name;
    Transport(Driver driver, String route, String name) {
        this.driver = driver;
        routeName = route;
        this.name = name;
    }

    Driver getDriver() {
        return driver;
    }

    public void move() {
        System.out.println("I am the Transport and I moving on " + routeName + "route.");
        printDriver();
    }

    void printDriver() {
        System.out.println("Driver is " + driver.toString());
    }

    @Override
    public String toString() {
        return "Transport, driver is " + getDriver() + ", route: " + routeName + ", name" + name;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Transport && driver.equals(((Transport) o).driver)
                && routeName.equals(((Transport) o).routeName) && name.equals(((Transport) o).name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driver, routeName, name);
    }
}
