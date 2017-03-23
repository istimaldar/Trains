package transport;

import cargo.Carriage;


import java.util.List;

/**
 * Created by istimaldar on 20.03.2017.
 */
abstract public class Train extends Transport {
    List<Carriage> carriages;
    Train(Driver driver, String route) {
        super(driver, route);
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

    abstract boolean canBeAdded(Carriage carriage);
}