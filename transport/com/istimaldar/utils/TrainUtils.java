package com.istimaldar.utils;

import com.istimaldar.transport.Train;

import java.util.List;

/**
 * Created by istimaldar on 30.03.2017.
 */
public class TrainUtils {

    public static void countTotalNumberOfPassengersAndBaggage(List<Train> trains) {
        int numberOfPassengers = 0, numberOfBaggage = 0;
        for (Train train : trains) {
            numberOfPassengers += train.getTotalAmountOfPassengers();
            numberOfBaggage += train.getTotalAmountOfBaggage();
        }
        System.out.println("Total number of passengers = " + numberOfPassengers);
        System.out.println("Total number of baggage = " + numberOfBaggage);
    }
}