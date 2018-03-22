abstract public class Deal {
    /*
    TODO
    Need deal activators i.e,
    Buy X amount of items results in discount
    Need destructor handler, i.e. when range ends
     */

    private int id;
    private String name, description;
    private DateRange range;
    private float amountOff;

    abstract public float discount(float price);

    public Deal(int id, String name, String description, DateRange range, float amountOff) {
        setId(id);
        setName(name);
        setDescription(description);
        setRange(range);
        setAmountOff(amountOff);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public DateRange getRange() {
        return range;
    }

    public float getAmountOff() {
        return amountOff;
    }

    private void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRange(DateRange range) {
        this.range = range;
    }

    public void setAmountOff(float amountOff){
        if(getAmountOff() > 0)
            this.amountOff = amountOff;
        else
            throw new IllegalArgumentException("Deal must have more than 0 off");
    }
}