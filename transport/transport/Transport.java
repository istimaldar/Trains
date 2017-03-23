package transport;

/**
 * Created by istimaldar on 20.03.2017.
 */
abstract public class Transport {
    private Driver driver;
    String routeName;
    Transport(Driver driver, String route) {
        this.driver = driver;
        routeName = route;
    }
    public Driver getDriver() {
        return driver;
    }
    public void move() {
        System.out.println("I am the Transport and I moving on " + routeName + "route.");
        printDriver();
    }
    protected void printDriver() {
        System.out.println("Driver is " + driver.toStrng());
    }
}
