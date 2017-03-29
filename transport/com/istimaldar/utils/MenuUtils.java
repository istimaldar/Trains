package com.istimaldar.utils;

import com.istimaldar.cargo.*;
import com.istimaldar.transport.Driver;
import com.istimaldar.transport.FreightTrain;
import com.istimaldar.transport.PassengerTrain;
import com.istimaldar.transport.Train;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by istimaldar on 23.03.2017.
 */
public class MenuUtils {
    public static int printMenu(String header, String [] variants) {
        int selected = 0;
        Scanner reader = new Scanner(System.in);
        try {
            System.out.println(header);
            for (int i = 0; i < variants.length; i++) {
                System.out.println((i + 1) + ". " + variants[i]);
            }
            selected = reader.nextInt() - 1;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return selected;
    }

    private static <T> String[] toStringArray(ArrayList<T> list) {
        String [] result = new String[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i).toString();
        }
        return result;
    }

    public static Driver addDriver() {
        Driver driver = null;
        Scanner reader = new Scanner(System.in);
        try {
            System.out.println("Enter first name: ");
            String firstName = reader.next();
            System.out.println("Enter last name: ");
            String lastName = reader.next();
            driver = new Driver(firstName, lastName);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }

    public static String addRoute() {
        String name = "";
        Scanner reader = new Scanner(System.in);
        try {
            System.out.println("Enter route name: ");
            name = reader.next();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return name;
    }

    public static Train addTrain(ArrayList<Driver> drivers, ArrayList<String> routes) {
        Train train = null;
        int n = printMenu("Select train's type:", new String [] {"Freight Train", "Passenger Train"});
        Scanner reader = new Scanner(System.in);
        try {
            System.out.println("Enter train's name:");
            String name = reader.next();
            int driver = printMenu("Select the driver:", toStringArray(drivers));
            int route = printMenu("Select the route:", toStringArray(routes));
            switch (n) {
                case 1:
                    train = new FreightTrain(drivers.get(driver), routes.get(route), name);
                case 2:
                    train = new PassengerTrain(drivers.get(driver), routes.get(route), name);
                default:
                    throw new IllegalArgumentException("No such train type");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return train;
    }

    public static void selectTrain(ArrayList<Train> trains) {
        int trainIndex = printMenu("Select the driver:", toStringArray(trains));
        Train train = trains.get(trainIndex);
        int n = printMenu("Select the train:", new String [] {"Delete", "Add carriage", "Show info",
                "Select carriage", "Back"});
        switch (n) {
            case 0:
                trains.remove(trainIndex);
                break;
            case 1:
                addCarriage(train);
                break;
            case 2:
                //TODO: Full train info
                break;
            case 3:
                selectCarriage(train);
                break;
            case 4:
                //TODO: Back
                break;
            default:
                throw new IllegalArgumentException("No such carriage action");
        }
    }

    public static void addCarriage(Train train) {
        int type = printMenu("Select an action:", new String [] {"Freight carriage", "Compartment carriage",
                "Economy Class Carriage"});
        switch (type) {
            case 1:
                train.addCarriage(new FreightCarriage());
                break;
            case 2:
                train.addCarriage(new CompartmentCarriage());
                break;
            case 3:
                train.addCarriage(new EconomyClassCarriage());
                break;
            default:
                throw new IllegalArgumentException("No such carriage type");
        }
    }

    public static void selectCarriage(Train train) {
        int carriageIndex = printMenu("Select the driver:", toStringArray(train.getCarriages()));
        Carriage carriage = train.getCarriages().get(carriageIndex);
        int n = printMenu("Select the action:", new String [] {"Delete", "Add cargo", "Show info", "Back"});
        switch (n) {
            case 0:
                train.removeCargo(carriageIndex);
                break;
            case 1:
                addCargo(carriage);
                break;
            case 2:
                //TODO: Full train info
                break;
            case 3:

                break;
            case 4:
                //TODO: Back
                break;
            default:
                throw new IllegalArgumentException("No such carriage action");
        }
    }

    public static void addCargo(Carriage carriage) {
        int n = printMenu("Select the type of cargo:", new String [] {"Baggage", "Cargo", "Passenger"});
        Scanner reader = new Scanner(System.in);
        try {
            switch (n) {
                case 1:
                    System.out.println("Enter the name of owner");
                    String owner = reader.next();
                    System.out.println("Enter the number of baggage");
                    carriage.load(new Baggage(owner, reader.nextFloat()));
                    break;
                case 2:
                    System.out.println("Enter the type of cargo");
                    String type = reader.next();
                    System.out.println("Enter the number of cargo");
                    carriage.load(new Cargo(type, reader.nextFloat()));
                    break;
                case 3:
                    System.out.println("Enter the first name of passenger");
                    String firstName = reader.next();
                    System.out.println("Enter the last name of passenger");
                    carriage.load(new Passenger(firstName, reader.next()));
                    break;
                default:
                    throw new IllegalArgumentException("No such carriage type");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
