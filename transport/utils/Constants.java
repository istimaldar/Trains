package utils;

import cargo.Baggage;
import cargo.Loadable;
import cargo.Passenger;

import java.util.Scanner;

/**
 * Created by istimaldar on 23.03.2017.
 */
public class Constants {
    public static final Loadable EMPTY_SEAT = new Passenger("","");
    public static final Loadable EMPTY_BAGGAGE = new Baggage("",0);
    public static final Scanner READER = new Scanner(System.in);
}
