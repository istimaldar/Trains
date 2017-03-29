package com.istimaldar.transport;

import java.io.Serializable;

public class Driver implements Serializable {
    private String firstName;
    private String lastName;

    public Driver(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String toString() {
        return firstName + " " + lastName;
    }

}
