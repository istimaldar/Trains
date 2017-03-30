package com.istimaldar.cargo;

import java.util.Objects;

public class CompartmentCarriage extends PassengerCarriage {

    public CompartmentCarriage() {
        super(62);
    }

    @Override
    public String toString() {
        return "Compartment Carriage";
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof CompartmentCarriage && super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cargo, levelOfComfort);
    }
}
