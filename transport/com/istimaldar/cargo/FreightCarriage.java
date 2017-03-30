package com.istimaldar.cargo;

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
}
