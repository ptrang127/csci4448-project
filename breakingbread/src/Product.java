import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Product implements Cloneable{
    private int id, quantity;
    private String name, description, path;
    private float price;
    private List<Deal> deals;

    protected Product clone() {
        return new Product(this.id,this.quantity,this.name,this.description,this.path,this.price);
    }

    public Product(int id, int quantity, String name, String description, String path, float price) {
        setId(id);
        setQuantity(quantity);
        setName(name);
        setDescription(description);
        setPrice(price);
        setPath(path);
        deals = new ArrayList<Deal>();
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPath() { return path; }

    public float getPrice(){
        return price;
    }
    public float getDiscountPrice() {
        //Get discounted price
        float realPrice = price;
        Iterator<Deal> dealItr = deals.iterator();
        while(dealItr.hasNext()){
            realPrice = dealItr.next().discount(realPrice);
        }
        return realPrice;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuantity(int quantity) {
        if(getQuantity() >= 0)
            this.quantity = quantity;
        else
            throw new IllegalArgumentException("Quantity must be non-negative");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPath(String path){ this.path = path;}

    public void setPrice(float price) {
        if(getQuantity() >= 0)
            this.price = price;
        else
            throw new IllegalArgumentException("Quantity must be non-negative");
    }

    public void addDeal(Deal deal){
        deals.add(deal);
    }

    public void removeDeal(Deal deal){
        deals.remove(deal);
    }

    @Override
    public String toString() {
        return getName();
    }
}
