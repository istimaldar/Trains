package utils;

import cargo.Baggage;
import cargo.Loadable;
import cargo.Passenger;

/**
 * Created by istimaldar on 23.03.2017.
 */
public class Constants {
    public static final Loadable EMPTY_SEAT = new Passenger("","");
    public static final Loadable EMPTY_BAGGAGE = new Baggage((Passenger) EMPTY_SEAT,0);
}
