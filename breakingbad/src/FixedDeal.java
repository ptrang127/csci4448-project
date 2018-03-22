public class FixedDeal extends Deal{
    public FixedDeal(int id, String name, String description, DateRange range, float amountOff) {
        super(id, name, description, range, amountOff);
    }

    @Override
    public float discount(float price) {
        return price - getAmountOff();
    }
}
