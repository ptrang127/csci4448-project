public class PercentDeal extends Deal {
    public PercentDeal(int id, String name, String description, DateRange range, float amountOff) {
        super(id, name, description, range, amountOff);
    }

    @Override
    public void setAmountOff(float amountOff) {
        if(amountOff <= 1)
            super.setAmountOff(amountOff);
        else
            throw new IllegalArgumentException("Deal must be between 0% and 100% off");
    }

    @Override
    public float discount(float price) {
        return price * getAmountOff();
    }
}
