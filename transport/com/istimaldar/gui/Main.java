package com.istimaldar.gui;

import com.istimaldar.cargo.*;
import com.istimaldar.transport.Driver;
import com.istimaldar.transport.FreightTrain;
import com.istimaldar.transport.PassengerTrain;
import com.istimaldar.transport.Train;
import com.istimaldar.utils.ListUtils;

import java.util.ArrayList;

import static com.istimaldar.utils.MenuUtils.addDriver;
import static com.istimaldar.utils.MenuUtils.*;

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
            int object = printMenu("Select an object:", new String [] {"Driver", "Route", "Train", "Exit"});
            if (object > 3) {
                break;
            }
            int action = printMenu("Select an action:", new String [] {"Add", "Show", "Select"});
            switch (object  * SECOND_MENU_ITEMS + action) {
                case 0:
                    drivers.add(addDriver());
                    break;
                case 1:
                    //TODO: Add the ability to display drivers
                    break;
                case 2:
                    //TODO: Add the ability to select drivers
                    break;
                case 3:
                    routes.add(addRoute());
                    break;
                case 4:
                    //TODO: Add the ability to display routes
                    break;
                case 5:
                    //TODO: Add the ability to display routes
                    break;
                case 6:
                    trains.add(addTrain(drivers, routes));
                    break;
                case 7:
                    //TODO: Add the ability to display routes
                    break;
                case 8:
                    selectTrain(trains);
                    break;
                default:
                    exit = 1;
            }
            ListUtils.serializeObject(drivers, "data/drivers");
            ListUtils.serializeObject(routes, "data/routes");
            ListUtils.serializeObject(trains, "data/trains");
        }
    }


}
