import java.util.*;

public class Cart {

    private List<Product> items = new ArrayList<>();
    private float cost = 0;


    public Cart() {}

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
    public void customizeProduct(customProduct product, String customization){

    }
    public float getCost() { //total cost of items in cart it

        for(int i = 0; i < items.size(); i ++) {
            cost += items.get(i).getPrice() * items.get(i).getQuantity();
        }
        return cost;
    }

    public int getSize() {
        int size = 0;
        for(int i = 0; i < items.size(); i ++) {
            size += items.get(i).getQuantity();
        }
        return size;
    }

    public List<Product> getItems(){
        return items;
    }
}

