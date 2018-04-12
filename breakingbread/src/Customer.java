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
        order.clearCart();
    }

    public void addItem(Product newProduct){
        order.addItem(newProduct);
    }

    public void removeItem(Product newProduct){
        order.removeItem(newProduct);
    }

    public int changeItem(int oldId, Product newProduct){
        return 1;
    }

}