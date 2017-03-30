package com.istimaldar.cargo;

import java.util.ArrayList;
import java.util.Objects;

abstract public class Carriage {
    ArrayList<Loadable> cargo;

    public void load(Loadable cargo) {
        if (canBeLoaded(cargo)) {
            this.cargo.add(cargo);
        }
    }

    @Override
    abstract public String toString();

    abstract boolean canBeLoaded(Loadable cargo);

    public abstract int getTotalAmountOfPassengers();

    public abstract double getTotalAmountOfBaggage();

    @Override
    public boolean equals(Object o) {
        return o instanceof Carriage && cargo.equals(((Carriage) o).cargo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cargo);
    }
}
