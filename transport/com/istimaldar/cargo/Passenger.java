package com.istimaldar.cargo;

/**
 * Created by istimaldar on 23.03.2017.
 */
public class Passenger implements Loadable {
    private String firstName;
    private String lastName;
    private boolean empty;

    public Passenger(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        if (firstName.equals("") && lastName.equals("")) {
            empty = true;
        }
        else {
            empty = false;
        }
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
}
