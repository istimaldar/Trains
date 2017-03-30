package com.istimaldar.gui;

import com.istimaldar.transport.Driver;
import com.istimaldar.transport.Train;
import com.istimaldar.utils.ListUtils;

import java.util.ArrayList;

import static com.istimaldar.utils.MenuUtils.*;
import static com.istimaldar.utils.TrainUtils.countTotalNumberOfPassengersAndBaggage;

/**
 * Created by istimaldar on 23.03.2017.
 */
public class Main {
    private static final int SECOND_MENU_ITEMS = 3;
    public static  void main(String [] args) {
        ArrayList<Driver> drivers = new ArrayList<>();
        ArrayList<String> routes = new ArrayList<>();
        ArrayList<Train> trains = new ArrayList<>();
        int exit = 0;
        //drivers = (ArrayList<Driver>) ListUtils.deserialzeObject("drivers");
        //routes = (ArrayList<String>) ListUtils.deserialzeObject("drivers");
        //trains = (ArrayList<Train>) ListUtils.deserialzeObject("drivers");
        while (exit == 0) {
            int object = printMenu("Select an object:", new String[]{"Driver", "Route", "Train", "Total number of passengers and luggage", "Exit"});
            int action = 0;
            if (object < 3) {
                action = printMenu("Select an action:", new String [] {"Add", "Show", "Select"});
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
                default:
                    exit = 1;
            }
            ListUtils.serializeObject(drivers, "data/drivers");
            ListUtils.serializeObject(routes, "data/routes");
            ListUtils.serializeObject(trains, "data/trains");
        }
    }

}
