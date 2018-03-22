import User.java;
import Product.java;
import Cart.java;
import Inventory.java;

public class Customer {
    private Cart order;
    private ArrayList<Cart> orderHistory;
    private String shippingAddress;

    public Customer (String shippingAddress){
        setAddress(shippingAddress);
    }

    public String getAddress(){
        return shippingAddress;
    }

    public void setAddress(String address){
        this.shippingAddress = address;
    }

    public ArrayList<Cart> getHistory(){
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

    public int removeItem(int oldID){
        Inventory.removeProduct(oldID);
        return 1;
    }

    public int changeItem(int oldID, Product newProduct){
        Inventory.changeProduct(oldID, newProduct);
        return 1;
    }

}