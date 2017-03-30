package com.istimaldar.cargo;

import java.util.Objects;

public class Passenger implements Loadable {
    private String firstName;
    private String lastName;
    private boolean empty;

    public Passenger(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        empty = firstName.equals("") && lastName.equals("");
    }

    @Override
    public String getName() {
        if (empty) {
            return "FREE SEAT";
        }
        return firstName + " " + lastName;
    }

    @Override
    public float getAmount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return empty;
    }

    @Override
    public String toString() {
        return "Passenger, name is " + firstName + " " + lastName + ".";
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Passenger && firstName.equals(((Passenger) o).firstName)
                && firstName.equals(((Passenger) o).firstName) && empty == ((Passenger) o).empty;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, empty);
    }
}
