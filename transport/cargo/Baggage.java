package cargo;


/**
 * Created by istimaldar on 23.03.2017.
 */
public class Baggage implements Loadable {
    private String owner;
    private float amount;

    public Baggage(String owner, float amount) {
        this.owner = owner;
        if (amount < 0) {
            throw new IllegalArgumentException("Cargo weight can not be less than 0");
        }
        this.amount = amount;
    }

    @Override
    public String getName() {
        if (amount == 0) {
            return "NO BAGGAGE";
        }
        return owner + "'s baggage, " + amount + "g." ;
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
