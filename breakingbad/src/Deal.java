package BreakingBread;
import java.util.Date;

abstract public class Deal {
    /*
    TODO
    Need deal activators i.e,
    Buy X amount of items results in discount
     */

    private int id;
    private String name, description;
    private Date start,end;
    private float amountOff;

    abstract public float discount(float price);

    public Deal() {
        //TODO
    }

    public Deal(int id, String name, String description, Date start, Date end, float amountOff) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.start = start;
        this.end = end;
        this.amountOff = amountOff;
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

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public float getAmountOff() {
        return amountOff;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public void setAmountOff(float amountOff) {
        this.amountOff = amountOff;
    }
}

//Should this really have it's own file?
class FixedDeal extends Deal {
    @Override
    public float discount(float price) {
        return price - this.getAmountOff();
    }
}

class PercentDeal extends Deal {
    @Override
    public float discount(float price) {
        return price * this.getAmountOff();
    }
}