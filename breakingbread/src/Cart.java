import java.util.*;
import java.io.*;//just to see the colors on intellij
public class Cart extends Inventory{
    ArrayList<product> Products = new ArrayList<product>();
    List<int> Prices = new List<int>();
    public float cost = 0;
    public Cart(Product product){
        Product.add(product);
    }
    private static ArrayList[] addItem(Product product){
        Product.add(product);
        System.out.println("Item Successfully Added to Cart");
        return Products[];
        //possible addition of continue shopping or checkout on display
    }
    private static ArrayList[] removeItem(Product product){
        Products.remove(product);
        System.out.println(Products[]); //maybe iterate and print each item
        return Products[];
    }
    private void clearCart(){
        Products.clear(); //better preformance that remove all apparently
        System.out.println("Cart Cleared");

    }
    public float getCost() { //total cost of items in cart it

        Iterator<String> i = currentCart.iterator(); //this should work for the interator, length of the items
        while(i.hasNext()) //possibly create a new iterator
        {
            //iterate through all items in arraylist
            //for every item
            cost += (Products.get(i.next(price)));
        }
        System.out.println(cost);
        return cost;
    }
}
//possibly use visitor design pattern?
public interface