package transport;

import cargo.Carriage;


import java.util.ArrayList;

/**
 * Created by istimaldar on 20.03.2017.
 */
abstract public class Train extends Transport {
    ArrayList<Carriage> carriages;
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

    public ArrayList<Carriage> getCarriages() {
        return carriages;
    }

    abstract public void removeCargo(int i);

    abstract public String toString();

    abstract boolean canBeAdded(Carriage carriage);
}