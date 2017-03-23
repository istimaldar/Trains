package gui;

import cargo.*;
import transport.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by istimaldar on 23.03.2017.
 */
public class Main {
    public static  void main(String [] args) {
        ArrayList<Driver> drivers = new ArrayList<>();
        ArrayList<String> routes = new ArrayList<>();
        ArrayList<Train> trains = new ArrayList<>();
        int exit = 0;
        while (exit == 0) {
            switch (printFirstLevelMenu()) {
                case 1:
                    drivers.add(addDriver());
                    break;
                case 2:
                    routes.add(addRoute());
                    break;
                case 3:
                    trains.add(addTrain(drivers, routes));
                    break;
                case 4:
                    addCarriage(trains);
                    break;
                case 5:
                    addCargo(trains);
                    break;
                case 6:
                    showDrivers(drivers);
                    break;
                default:
                    exit = 1;
            }
            clearConsole();
        }
    }

    private static int printFirstLevelMenu() {
        System.out.println("Select an option:");
        System.out.println("1. Add a driver.");
        System.out.println("2. Add a route.");
        System.out.println("3. Add a train.");
        System.out.println("4. Add a carriage.");
        System.out.println("5. Load carriage.");
        System.out.println("6. Show drivers.");
        System.out.println("7. Show routes.");
        System.out.println("8. Show trains.");
        Scanner reader = new Scanner(System.in);
        return reader.nextInt();
    }

    private static Driver addDriver() {
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter first name: ");
        String firstName = reader.next(); // Scans the next token of the input as an int.
        System.out.println("Enter last name: ");
        String lastName = reader.next(); // Scans the next token of the input as an int.
        return new Driver(firstName, lastName);
    }

    private static String addRoute() {
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter route name: ");
        return reader.next();
    }

    private static Driver printDriverSelectMenu(ArrayList<Driver> drivers) {
        System.out.println("Select a driver:");
        for (int i = 0; i < drivers.size(); i++) {
            System.out.println((i + 1) + ". " + drivers.get(i).toString());
        }
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        return drivers.get(reader.nextInt() - 1);
    }

    private static String printRouteSelectMenu(ArrayList<String> routes) {
        System.out.println("Select a route:");
        for (int i = 0; i < routes.size(); i++) {
            System.out.println((i + 1) + ". " + routes.get(i));
        }
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        return routes.get(reader.nextInt() - 1);
    }

    private static Train addTrain(ArrayList<Driver> drivers, ArrayList<String> routes) {
        System.out.println("Select train's type:");
        System.out.println("1. Freight Train");
        System.out.println("2. Passenger Train");
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        int n = reader.nextInt();
        System.out.println("Enter train's name:");
        String name = reader.next();
        switch (n) {
            case 1:
                return new FreightTrain(printDriverSelectMenu(drivers), printRouteSelectMenu(routes), name);
            case 2:
                return new PassengerTrain(printDriverSelectMenu(drivers), printRouteSelectMenu(routes), name);
            default:
                throw new IllegalArgumentException("No such train type");
        }
    }

    private static Train printTrainSelectMenu(ArrayList<Train> trains) {
        System.out.println("Select a train:");
        for (int i = 0; i < trains.size(); i++) {
            System.out.println((i + 1) + ". " + trains.get(i).toString());
        }
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        return trains.get(reader.nextInt() - 1);
    }

    private static void addCarriage(ArrayList<Train> trains) {
        Train train = printTrainSelectMenu(trains);
        System.out.println("Select carriage type:");
        System.out.println("1. Freight Carriage");
        System.out.println("2. Compartment Carriage");
        System.out.println("3. Compartment Carriage");
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        switch (reader.nextInt()) {
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

    private static Carriage printCarriageMenu(Train train) {
        System.out.println("Select a carriage:");

        for (int i = 0; i < train.getCarriagesSize(); i++) {
            System.out.println((i + 1) + ". " + train.getCarriage(i).toString());
        }
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        return train.getCarriage(reader.nextInt());
    }

    private static void addCargo(ArrayList<Train> trains) {
        Train train = printTrainSelectMenu(trains);
        Carriage carriage = printCarriageMenu(train);
        System.out.println("Select cargo type:");
        System.out.println("1. Baggage");
        System.out.println("2. Cargo");
        System.out.println("3. Passenger");
        Scanner reader = new Scanner(System.in);
        switch (reader.nextInt()) {
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

    private static void showDrivers(ArrayList<Driver> drivers) {
        System.out.println("Drivers list:");
        for (int i = 0; i < drivers.size(); i++) {
            System.out.println((i + 1) + ". " + drivers.get(i).toString());
        }
    }

    public static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }
}
