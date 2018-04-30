import java.util.*;

public class Cart {

    ArrayList<Product> items = new ArrayList<>();
    public float cost = 0;


    public Cart() {

    }

    public void addItem(Product newProduct){
        if(Inventory.checkProduct(newProduct)) {
            items.add(newProduct);
            System.out.println("Item Successfully Added to Cart");
            //possible addition of continue shopping or checkout on display
        } else {
            System.out.println("Item could not be added");
        }

    }

    public void removeItem(Product newProduct){
        System.out.println(newProduct.getName() + "removed");
        items.remove(newProduct);
    }

    public void clearCart(){
        items.clear(); //better performance that removes all apparently
        System.out.println("Cart Cleared");

    }
    public void customizeProduct{
        colorCakeDecorator(customProduct, String color);
    }
    public float getCost() { //total cost of items in cart it

        for(int i = 0; i < items.size(); i ++) {
            cost += items.get(i).getPrice();
        }
        return cost;
    }
}

