package cargo;

import java.util.List;

/**
 * Created by istimaldar on 23.03.2017.
 */
abstract public class Carriage {
    List<Loadable> cargo;

    public void load(Loadable cargo) {
        if (canBeLoaded(cargo)) {
            this.cargo.add(cargo);
        }
    }

    abstract boolean canBeLoaded(Loadable cargo);
}
