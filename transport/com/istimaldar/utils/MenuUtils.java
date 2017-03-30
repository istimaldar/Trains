package com.istimaldar.utils;

import com.istimaldar.cargo.*;
import com.istimaldar.transport.Driver;
import com.istimaldar.transport.FreightTrain;
import com.istimaldar.transport.PassengerTrain;
import com.istimaldar.transport.Train;

import java.util.List;
import java.util.Scanner;

public class MenuUtils {
    public static int printMenu(String header, String [] variants) {
        Scanner reader = new Scanner(System.in);
        System.out.println(header);
        for (int i = 0; i < variants.length; i++) {
            System.out.println((i + 1) + ". " + variants[i]);
        }
        return reader.nextInt() - 1;
    }

    private static <T> String[] toStringArray(List<T> list) {
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

    public static <T> void display(String header,List<T> elements) {
        System.out.println(header);
        int index = 1;
        for(T element : elements) {
            System.out.println((index++) + ". " + element);
        }
    }

    public static void selectDriver(List<Driver> drivers) {
        int driverIndex = printMenu("Select the driver:", toStringArray(drivers));
        System.out.println("You selected: " + drivers.get(driverIndex));
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

    public static void selectRoute(List<String> routes) {
        int driverIndex = printMenu("Select the route:", (String [])routes.toArray());
        System.out.println("You selected: " + routes.get(driverIndex));
    }

    public static Train addTrain(List<Driver> drivers, List<String> routes) {
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

    public static void selectTrain(List<Train> trains) {
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

    private static void addCarriage(Train train) {
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

    private static void selectCarriage(Train train) {
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
                //TODO: Back
                break;
            default:
                throw new IllegalArgumentException("No such carriage action");
        }
    }

    private static void addCargo(Carriage carriage) {
        int n = printMenu("Select the type of cargo:", new String [] {"Baggage", "Cargo", "Passenger"});
        Scanner reader = new Scanner(System.in);
        try {
            switch (n) {
                case 1:
                    System.out.println("Enter the name of owner");
                    String owner = reader.next();
                    System.out.println("Enter the number of baggage");
                    float amount = reader.nextFloat();
                    if (amount < 0) {
                        throw new IllegalArgumentException("Cargo weight can not be less than 0");
                    }
                    carriage.load(new Baggage(owner, amount));
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

    public static void saveAll(List<Driver> drivers, List<String> routes, List<Train> trains) {
        ListUtils.serializeList(drivers, "data/drivers");
        ListUtils.serializeList(routes, "data/routes");
        ListUtils.serializeList(trains, "data/trains");
    }

    public static void loadAll(List<Driver> drivers, List<String> routes, List<Train> trains) {
        drivers.clear();
        routes.clear();
        trains.clear();
        ListUtils.deserialzeList(drivers, "data/drivers");
        ListUtils.deserialzeList(routes, "data/routes");
        ListUtils.deserialzeList(trains, "data/trains");
    }

}
