import java.util.*;
public class Cart extends Inventory{

    ArrayList<Product> items = new ArrayList<>();
    public float cost = 0;

    public Cart(){
    }

    public ArrayList<Product> addItem(Product newProduct){
        items.add(newProduct);
        System.out.println("Item Successfully Added to Cart");
        return items;
        //possible addition of continue shopping or checkout on display
    }

    public ArrayList<Product> removeItem(Product newProduct){
        items.remove(newProduct);
        return items;
    }

    public void clearCart(){
        items.clear(); //better preformance that remove all apparently
        System.out.println("Cart Cleared");

    }
    public float getCost() { //total cost of items in cart it

        for(int i = 0; i < items.size(); i ++) {
            cost += items.get(i).getPrice();
        }
        return cost;
    }
}