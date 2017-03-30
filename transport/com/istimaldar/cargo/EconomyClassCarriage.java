package com.istimaldar.cargo;

import java.util.Objects;

public class EconomyClassCarriage extends PassengerCarriage {

    public EconomyClassCarriage() {
        super(80);
    }

    @Override
    public String toString() {
        return "Economy Class Carriage";
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof EconomyClassCarriage && super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cargo, levelOfComfort);
    }
}
