import java.util.*;

public class Cart {

    private List<Product> items = new ArrayList<>();


    public Cart() {}

    public void addItem(Product newProduct){
        if(Inventory.checkProduct(newProduct)) {
            items.add(newProduct);
        } else {
            System.out.println("Item could not be added");
        }

    }

    public void removeItem(int ID){
        for(int i = 0; i < items.size(); i++) {
            if(ID == items.get(i).getId()){
                items.remove(items.get(i));
            }
        }
    }

    public void clearCart(){
        items.clear(); //better performance that removes all apparently
        System.out.println("Cart Cleared");

    }
    public void customizeProduct(customProduct product, String customization){

    }
    public float getCost() { //total cost of items in cart it
        float cost = 0;
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

