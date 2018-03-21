import java.util.Date;

abstract public class Deal {
    /*
    TODO
    Need deal activators i.e,
    Buy X amount of items results in discount
    Need destructor handler, i.e. when range ends
     */
    protected class DateRange {
        private Date start,end;

        public DateRange(){
            setStart(new Date(0));
            setEnd(new Date(0));
        }

        public DateRange(Date start, Date end){
            setStart(start);
            setEnd(end);
        }

        public Date getStart() {
            return start;
        }

        public Date getEnd() {
            return end;
        }

        public void setStart(Date start) {
            if(getEnd().before(getStart()))
                //Throw exception if end is before beginning but not if they're at the same time
                throw new IllegalArgumentException("Start date must be before end date");
            else
                this.start = start;
        }

        public void setEnd(Date end) {
            if(getEnd().before(getStart()))
                //Throw exception if end is before beginning but not if they're at the same time
                throw new IllegalArgumentException("Start date must be before end date");
            else if(!getEnd().equals(getStart()) && getEnd().before(new Date()))
                throw new IllegalArgumentException("End date must be after current date");
            else
                this.end = end;
        }

        public boolean inRange(Date check){
            if(getEnd().equals(getStart()))
                //Infinite time is represented by equal start and end
                return true;
            else if(getEnd().before(check) || getStart().after(check))
                return false;
            else
                //If they're not equal and check doesn't fall outside the range it's in range
                return true;
        }

    }

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

    public void setId(int id) {
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

//Should this really have it's own file?
class FixedDeal extends Deal {
    public FixedDeal(int id, String name, String description, Deal.DateRange range, float amountOff) {
        super(id, name, description, range, amountOff);
    }

    @Override
    public float discount(float price) {
        return price - getAmountOff();
    }
}

class PercentDeal extends Deal {
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