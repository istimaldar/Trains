package com.istimaldar.transport;

import java.io.Serializable;
import java.util.Objects;

public class Driver implements Serializable {
    private String firstName;
    private String lastName;

    public Driver(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Driver && firstName.equals(((Driver) o).firstName)
                && firstName.equals(((Driver) o).firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

}
