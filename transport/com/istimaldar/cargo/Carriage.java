package com.istimaldar.cargo;

import java.util.ArrayList;

abstract public class Carriage {
    ArrayList<Loadable> cargo;

    public void load(Loadable cargo) {
        if (canBeLoaded(cargo)) {
            this.cargo.add(cargo);
        }
    }

    abstract public String toString();

    abstract boolean canBeLoaded(Loadable cargo);

    public abstract int getTotalAmountOfPassengers();

    public abstract double getTotalAmountOfBaggage();
}
