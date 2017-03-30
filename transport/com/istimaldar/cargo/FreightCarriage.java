package com.istimaldar.cargo;

import java.util.Objects;

public class FreightCarriage extends Carriage {
    @Override
    public String toString() {
        return "Freight Carriage";
    }

    @Override
    boolean canBeLoaded(Loadable cargo) {
        return cargo instanceof Cargo;
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
        return o instanceof FreightCarriage && super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cargo);
    }
}
