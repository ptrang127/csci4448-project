import java.util.*;

public class Cart extends Inventory{

    ArrayList<Product> items = new ArrayList<>();
    public float cost = 0;


    public Cart(){

    }

    public void addItem(Product newProduct){
        items.add(newProduct);
        System.out.println("Item Successfully Added to Cart");
        //possible addition of continue shopping or checkout on display
    }

    public void removeItem(Product newProduct){
        items.remove(newProduct);
    }

    public void clearCart(){
        items.clear(); //better performance that removes all apparently
        System.out.println("Cart Cleared");

    }
    public float getCost() { //total cost of items in cart it

        for(int i = 0; i < items.size(); i ++) {
            cost += items.get(i).getPrice();
        }
        return cost;
    }
}

