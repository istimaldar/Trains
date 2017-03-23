package gui;

import cargo.*;
import transport.*;

import java.util.ArrayList;

import static utils.Constants.READER;
import static utils.MenuUtils.printMenu;
import static utils.MenuUtils.toStringArray;

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
            clearConsole();
        }
    }

    private static Driver addDriver() {
        System.out.println("Enter first name: ");
        String firstName = READER.next(); // Scans the next token of the input as an int.
        System.out.println("Enter last name: ");
        String lastName = READER.next(); // Scans the next token of the input as an int.
        return new Driver(firstName, lastName);
    }

    private static String addRoute() {
        System.out.println("Enter route name: ");
        return READER.next();
    }

    private static Train printTrainSelectMenu(ArrayList<Train> trains) {
        System.out.println("Select a train:");
        for (int i = 0; i < trains.size(); i++) {
            System.out.println((i + 1) + ". " + trains.get(i).toString());
        }
        return trains.get(READER.nextInt() - 1);
    }

    private static Train addTrain(ArrayList<Driver> drivers, ArrayList<String> routes) {
        int n = printMenu("Select train's type:", new String [] {"Freight Train", "Passenger Train"});
        System.out.println("Enter train's name:");
        String name = READER.next();
        int driver = printMenu("Select the driver:", toStringArray(drivers));
        int route = printMenu("Select the route:", toStringArray(routes));
        switch (n) {
            case 1:
                return new FreightTrain(drivers.get(driver), routes.get(route), name);
            case 2:
                return new PassengerTrain(drivers.get(driver), routes.get(route), name);
            default:
                throw new IllegalArgumentException("No such train type");
        }
    }

    private static void selectTrain(ArrayList<Train> trains) {
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

                break;
            case 4:
                //TODO: Back
                break;
            default:
                throw new IllegalArgumentException("No such carriage action");
        }
    }

    private static void addCargo(Carriage carriage) {
        int n = printMenu("Select the type of cargo:", new String [] {"Baggage", "Cargo", "Passenger"});
        switch (n) {
            case 1:
                System.out.println("Enter the name of owner");
                String owner = READER.next();
                System.out.println("Enter the number of baggage");
                carriage.load(new Baggage(owner, READER.nextFloat()));
                break;
            case 2:
                System.out.println("Enter the type of cargo");
                String type = READER.next();
                System.out.println("Enter the number of cargo");
                carriage.load(new Cargo(type, READER.nextFloat()));
                break;
            case 3:
                System.out.println("Enter the first name of passenger");
                String firstName = READER.next();
                System.out.println("Enter the last name of passenger");
                carriage.load(new Passenger(firstName, READER.next()));
                break;
            default:
                throw new IllegalArgumentException("No such carriage type");
        }
    }

    private static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            }
            else {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e) {
            //  Handle any exceptions.
        }
    }
}
