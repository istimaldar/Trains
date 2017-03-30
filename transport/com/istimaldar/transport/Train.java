package com.istimaldar.transport;

import com.istimaldar.cargo.Carriage;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

abstract public class Train extends Transport implements Serializable {
    List<Carriage> carriages;
    Train(Driver driver, String route, String name) {
        super(driver, route, name);
    }

    @Override
    public void move() {
        System.out.println("I am the Train and I moving on " + routeName + "route.");
        printDriver();
    }

    public void addCarriage(Carriage carriage) {
        if (canBeAdded(carriage)) {
            carriages.add(carriage);
        }
    }

    public List<Carriage> getCarriages() {
        return carriages;
    }

    abstract public void removeCargo(int i);

    abstract boolean canBeAdded(Carriage carriage);

    public abstract int getTotalAmountOfPassengers();

    public abstract double getTotalAmountOfBaggage();

    @Override
    public String toString() {
        return "Train, driver is " + getDriver() + ", route: " + routeName + ", name" + name;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Train && super.equals(o) && carriages.equals(((Train) o).carriages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDriver(), routeName, name, carriages);
    }
}