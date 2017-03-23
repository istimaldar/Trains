package gui;

import cargo.CompartmentCarriage;
import cargo.EconomClassCarriage;
import cargo.FreightCarriage;
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
        return drivers.get(reader.nextInt());
    }

    private static String printRouteSelectMenu(ArrayList<String> routes) {
        System.out.println("Select a route:");
        for (int i = 0; i < routes.size(); i++) {
            System.out.println((i + 1) + ". " + routes.get(i));
        }
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        return routes.get(reader.nextInt());
    }

    private static Train addTrain(ArrayList<Driver> drivers, ArrayList<String> routes) {
        System.out.println("Select train's type:");
        System.out.println("1. Freight Train");
        System.out.println("2. Passenger Train");
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        switch (reader.nextInt()) {
            case 1:
                return new FreightTrain(printDriverSelectMenu(drivers), printRouteSelectMenu(routes));
            case 2:
                return new PassengerTrain(printDriverSelectMenu(drivers), printRouteSelectMenu(routes));
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
        return trains.get(reader.nextInt());
    }

    private static void addCarriage(ArrayList<Train> trains) {
        System.out.println("Select carriage type:");
        System.out.println("1. Freight Carriage");
        System.out.println("2. Compartment Carriage");
        System.out.println("3. Compartment Carriage");
        Train train = printTrainSelectMenu(trains);
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        switch (reader.nextInt()) {
            case 1:
                train.addCarriage(new FreightCarriage());
                break;
            case 2:
                train.addCarriage(new CompartmentCarriage());
                break;
            case 3:
                train.addCarriage(new EconomClassCarriage());
                break;
            default:
                throw new IllegalArgumentException("No such carriage type");
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
