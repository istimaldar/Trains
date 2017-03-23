package cargo;

/**
 * Created by istimaldar on 23.03.2017.
 */
public class Cargo implements Loadable {
    private String type;
    private float amount;

    public Cargo(String type, float amount) {
        this.amount = amount;
        if (amount == 0) {
            this.type = "Air";
        }
        this.type = type;
    }

    @Override
    public String getName() {
        return type;
    }

    @Override
    public float getAmount() {
        return amount;
    }

    @Override
    public boolean isEmpty() {
        return amount == 0;
    }
}
