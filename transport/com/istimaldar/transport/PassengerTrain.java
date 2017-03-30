package com.istimaldar.transport;

import com.istimaldar.cargo.Carriage;
import com.istimaldar.cargo.FreightCarriage;

/**
 * Created by istimaldar
 */
public class PassengerTrain extends Train {
    public PassengerTrain(Driver driver, String route, String name) {
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
        return "Passenger Train " + name;
    }

    @Override
    boolean canBeAdded(Carriage carriage) {
        return !(carriage instanceof FreightCarriage);
    }

    @Override
    public int getTotalAmountOfPassengers() {
        int amountOfPassengers = 0;
        for (Carriage carriage : carriages) {
            amountOfPassengers += carriage.getTotalAmountOfPassengers();
        }
        return amountOfPassengers;
    }

    @Override
    public double getTotalAmountOfBaggage() {
        int amountOfBaggage = 0;
        for (Carriage carriage : carriages) {
            amountOfBaggage += carriage.getTotalAmountOfBaggage();
        }
        return amountOfBaggage;
    }
}
