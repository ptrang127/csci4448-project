import java.util.Date;

public class DateRange {
    private Date start, end;

    public DateRange() {
        setStart(new Date(0));
        setEnd(new Date(0));
    }

    public DateRange(Date start, Date end) {
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
        if (getEnd().before(getStart()))
            //Throw exception if end is before beginning but not if they're at the same time
            throw new IllegalArgumentException("Start date must be before end date");
        else
            this.start = start;
    }

    public void setEnd(Date end) {
        if (getEnd().before(getStart()))
            //Throw exception if end is before beginning but not if they're at the same time
            throw new IllegalArgumentException("Start date must be before end date");
        else if (!getEnd().equals(getStart()) && getEnd().before(new Date()))
            throw new IllegalArgumentException("End date must be after current date");
        else
            this.end = end;
    }

    public boolean inRange(Date check) {
        if (getEnd().equals(getStart()))
            //Infinite time is represented by equal start and end
            return true;
        else if (getEnd().before(check) || getStart().after(check))
            return false;
        else
            //If they're not equal and check doesn't fall outside the range it's in range
            return true;
    }
}
