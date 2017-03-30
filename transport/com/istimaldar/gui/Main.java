package com.istimaldar.gui;

import com.istimaldar.transport.Driver;
import com.istimaldar.transport.Train;

import java.util.ArrayList;
import java.util.InputMismatchException;

import static com.istimaldar.utils.MenuUtils.*;
import static com.istimaldar.utils.TrainUtils.countTotalNumberOfPassengersAndBaggage;

public class Main {
    private static final int SECOND_MENU_ITEMS = 3;
    public static  void main(String [] args) {
        ArrayList<Driver> drivers = new ArrayList<>();
        ArrayList<String> routes = new ArrayList<>();
        ArrayList<Train> trains = new ArrayList<>();
        int exit = 0, action = 0, object;
        while (exit == 0) {
            try {
                object = printMenu("Select an object:", new String[]{"Driver", "Route", "Train", "Total number of passengers and baggage", "Save", "Load", "Exit"});
                if (object < 3) {
                    action = printMenu("Select an action:", new String[]{"Add", "Show", "Select"});
                }
            } catch (InputMismatchException e) {
                System.out.println("Only numbers can be entered");
                continue;
            }
            switch (object  * SECOND_MENU_ITEMS + action) {
                case 0:
                    drivers.add(addDriver());
                    break;
                case 1:
                    display("List of drivers:", drivers);
                    break;
                case 2:
                    selectDriver(drivers);
                    break;
                case 3:
                    routes.add(addRoute());
                    break;
                case 4:
                    display("List of routes:", routes);
                    break;
                case 5:
                    selectRoute(routes);
                    break;
                case 6:
                    trains.add(addTrain(drivers, routes));
                    break;
                case 7:
                    display("List of trains:", trains);
                    break;
                case 8:
                    selectTrain(trains);
                    break;
                case 9:
                    countTotalNumberOfPassengersAndBaggage(trains);
                    break;
                case 12:
                    saveAll(drivers, routes, trains);
                    break;
                case 15:
                    loadAll(drivers, routes, trains);
                    break;
                default:
                    exit = 1;
            }
        }
    }

}
