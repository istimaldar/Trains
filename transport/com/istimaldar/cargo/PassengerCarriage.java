package com.istimaldar.cargo;

import java.util.ArrayList;
import java.util.Objects;

import static com.istimaldar.utils.Constants.EMPTY_BAGGAGE;
import static com.istimaldar.utils.Constants.EMPTY_SEAT;

abstract class PassengerCarriage extends Carriage {
    int levelOfComfort;

    PassengerCarriage(int seatsNum) {
        cargo = new ArrayList<>();
        initializeSeats(seatsNum);

    }

    private void initializeSeats(int seatsNum) {
        for (int i = 0; i < seatsNum * 2; i++) {
            if (i % 2 == 0) {
                cargo.add(EMPTY_SEAT);
            } else {
                cargo.add(EMPTY_BAGGAGE);
            }
        }
    }

    @Override
    boolean canBeLoaded(Loadable cargo) {
        return !(cargo instanceof Cargo);
    }

    @Override
    public int getTotalAmountOfPassengers() {
        int numberOfPassengers = 0, position = 0;
        for (Loadable c : cargo) {
            if ((position++) % 2 == 0) {
                if (!c.equals(EMPTY_SEAT)) {
                    numberOfPassengers++;
                }
            }
        }
        return numberOfPassengers;
    }

    @Override
    public double getTotalAmountOfBaggage() {
        int numberOfBaggage = 0, position = 0;
        for (Loadable c : cargo) {
            if ((position++) % 2 == 1) {
                if (!c.equals(EMPTY_BAGGAGE)) {
                    numberOfBaggage++;
                }
            }
        }
        return numberOfBaggage;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof PassengerCarriage && super.equals(o) &&
                levelOfComfort == ((PassengerCarriage) o).levelOfComfort;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cargo, levelOfComfort);
    }
}
