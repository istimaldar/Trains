package cargo;

import java.util.ArrayList;

/**
 * Created by istimaldar on 23.03.2017.
 */
abstract public class Carriage {
    ArrayList<Loadable> cargo;

    public void load(Loadable cargo) {
        if (canBeLoaded(cargo)) {
            this.cargo.add(cargo);
        }
    }

    abstract public String toString();

    abstract boolean canBeLoaded(Loadable cargo);
}
