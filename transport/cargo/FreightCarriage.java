package cargo;

/**
 * Created by istimaldar on 23.03.2017.
 */
public class FreightCarriage extends Carriage {
    @Override
    public String toString() {
        return "Freight Carriage";
    }

    @Override
    boolean canBeLoaded(Loadable cargo) {
        return cargo instanceof Cargo;
    }
}
