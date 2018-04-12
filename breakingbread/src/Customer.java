import java.util.*;

public class Customer extends User{

    private Cart order = new Cart();
    private List<Cart> orderHistory = new ArrayList<>();
    private String shippingAddress;

    public Customer(String address){
        setAddress(address);
    }

    public String getAddress(){
        return shippingAddress;
    }

    public void setAddress(String address){
        this.shippingAddress = address;
    }

    public List<Cart> getHistory(){
        return orderHistory;
    }

    public void addToHistory(Cart cart) {
        orderHistory.add(order);
    }

    public Cart getCart(){
        return order;
    }

    public void checkout(){
        addToHistory(order);
        order.items.clear();
    }

    public int addItem(Product newProduct){
        order.addItem(newProduct);
        return 1;
    }

    public int removeItem(int oldId){
        Inventory.removeProduct(oldId);
        return 1;
    }

    public int changeItem(int oldId, Product newProduct){
        Inventory.changeProduct(oldId, newProduct);
        return 1;
    }

}