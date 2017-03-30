package com.istimaldar.transport;

import com.istimaldar.cargo.Carriage;
import com.istimaldar.cargo.FreightCarriage;

import java.util.Objects;

public class FreightTrain extends Train {
    public FreightTrain(Driver driver, String route, String name) {
        super(driver, route, name);
    }

    @Override
    public void move() {
        System.out.println("I am the FreightTrain and I moving on " + routeName + "route.");
        printDriver();
    }

    @Override
    public void removeCargo(int i) {

    }

    @Override
    public String toString() {
        return "Freight Train " + name;
    }

    @Override
    boolean canBeAdded(Carriage carriage) {
        return carriage instanceof FreightCarriage;
    }

    @Override
    public int getTotalAmountOfPassengers() {
        return 0;
    }

    @Override
    public double getTotalAmountOfBaggage() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof FreightTrain && super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDriver(), routeName, name, carriages);
    }

}
