package cargo;

/**
 * Created by istimaldar on 23.03.2017.
 */
public class FreightCarriage extends Carriage {
    @Override
    boolean canBeLoaded(Loadable cargo) {
        return cargo instanceof Cargo;
    }
}
