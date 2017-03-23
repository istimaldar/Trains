package cargo;

import java.util.ArrayList;

import static utils.Constants.EMPTY_BAGGAGE;
import static utils.Constants.EMPTY_SEAT;

/**
 * Created by istimaldar on 23.03.2017.
 */
abstract public class PassengerCarriage extends Carriage {
    int levelOfComfort;

    public PassengerCarriage(int seatsNum) {
        cargo = new ArrayList<>();
        for (int i = 0; i < seatsNum * 2; i++) {
            if (i % 2 == 0)  {
                cargo.add(EMPTY_SEAT);
            }
            else {
                cargo.add(EMPTY_BAGGAGE);
            }
        }
    }

    @Override
    boolean canBeLoaded(Loadable cargo) {
        return !(cargo instanceof Cargo);
    }
}
