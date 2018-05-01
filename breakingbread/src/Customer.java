import java.util.*;

public class Customer extends User{

    public Cart order = new Cart();
    private List<Cart> orderHistory = new ArrayList<>();
    private String shippingAddress;

    public Customer(int id, String email, String password, String address){
        super(id,email,password);
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
        for(int i = 0; i < order.getItems().size(); i++) {
            Inventory.removeProduct(order.getItems().get(i));
        }
        addToHistory(order);
        order.clearCart();
    }

    public void addItem(Product newProduct){
        order.addItem(newProduct);
    }

    public void removeItem(int ID){ order.removeItem(ID); }

}