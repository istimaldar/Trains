package com.istimaldar.cargo;

import java.util.Objects;

public class Baggage implements Loadable {
    private String owner;
    private float amount;

    public Baggage(String owner, float amount) {
        this.owner = owner;
        this.amount = amount;
    }

    @Override
    public String getName() {
        if (amount == 0) {
            return "NO BAGGAGE";
        }
        return owner + "'s baggage, " + amount + "g." ;
    }

    @Override
    public float getAmount() {
        return amount;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public boolean isEmpty() {
        return amount == 0;
    }

    @Override
    public String toString() {
        return "Baggage, owned by " + owner + ", amount is " + amount + ".";
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Baggage && owner.equals(((Baggage) o).owner) && amount == ((Baggage) o).amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, amount);
    }
}
