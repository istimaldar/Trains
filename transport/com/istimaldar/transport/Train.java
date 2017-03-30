package com.istimaldar.transport;

import com.istimaldar.cargo.Carriage;

import java.io.Serializable;
import java.util.List;

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

    abstract public String toString();

    abstract boolean canBeAdded(Carriage carriage);

    public abstract int getTotalAmountOfPassengers();

    public abstract double getTotalAmountOfBaggage();
}