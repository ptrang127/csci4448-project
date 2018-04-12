import java.util.*;

public class Customer extends User{
    private Cart order;
    private List<Cart> orderHistory;
    private String shippingAddress;

    public Customer (String address){
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

    public int addToHistory(Cart cart){
        (if cart.status != "Failed" || cart.status != "New"){
            orderHistory.add(cart);
            return 1;
        }
        return 0;
    }

    public Cart getCart(){
        return order;
    }

    public int checkout(){
        //checkout stuff
    }

    public int addItem(Product newProduct){
        Inventory.addProduct(newProduct);
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