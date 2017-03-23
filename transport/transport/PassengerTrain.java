package transport;

import cargo.Carriage;
import cargo.FreightCarriage;

/**
 * Created by istimaldar on 23.03.2017.
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
    public String toString() {
        return "Passenger Train " + name;
    }

    @Override
    boolean canBeAdded(Carriage carriage) {
        return !(carriage instanceof FreightCarriage);
    }
}
