package com.istimaldar.cargo;

import java.util.Objects;

public class Cargo implements Loadable {
    private String type;
    private float amount;

    public Cargo(String type, float amount) {
        this.amount = amount;
        if (amount == 0) {
            this.type = "Air";
        }
        this.type = type;
    }

    @Override
    public String getName() {
        return type;
    }

    @Override
    public float getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Cargo, type is " + type + ", amount is " + amount + ".";
    }

    @Override
    public boolean isEmpty() {
        return amount == 0;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Cargo && type.equals(((Cargo) o).type) && amount == ((Cargo) o).amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, amount);
    }
}
