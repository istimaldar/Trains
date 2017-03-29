package com.istimaldar.utils;

import com.istimaldar.cargo.Baggage;
import com.istimaldar.cargo.Loadable;
import com.istimaldar.cargo.Passenger;

import java.util.Scanner;

/**
 * Created by istimaldar on 23.03.2017.
 */
public class Constants {
    public static final Loadable EMPTY_SEAT = new Passenger("","");
    public static final Loadable EMPTY_BAGGAGE = new Baggage("",0);
}
