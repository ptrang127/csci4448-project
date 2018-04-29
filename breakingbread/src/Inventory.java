import java.util.*;

public class Inventory {

    // singleton
    private static Inventory single_instance = null;
    private static List<Product> stock = new ArrayList<Product>();

    private Inventory() {
        Product kit = new Product(1, 20, "Cakes", "A basic vanilla cake", 4);
        stock.add(kit);
        Product kit2 = new Product(2, 48, "Cupcakes", "Batches of fresh cupcakes that come in packs of 4", 4);
        stock.add(kit2);
        Product kit3 = new Product(3, 20, "Pastries", "Basic pastry", 4);
        stock.add(kit3);
        Product kit4 = new Product(4, 30, "Bread", "Loaves of our best bread", 4);
        stock.add(kit4);
        Product kit5 = new Product(5, 30, "Scones", "Like the top of a fluffy muffin", 4);
        stock.add(kit5);
        Product kit6 = new Product(6, 120, "Donuts", "Creamy donuts", 4);
        stock.add(kit6);
        Product kit7 = new Product(7, 25, "Crepes", "Thin pancakes with creamy toppings", 4);
        stock.add(kit7);
        Product kit8 = new Product(8, 40, "Pie", "Hard crust pies", 4);
        stock.add(kit8);

    }

    public static Inventory getInstance() {
        if (single_instance == null) {
            single_instance = new Inventory();
        }
        return single_instance;
    }

    public void addProduct(Product newProduct) {
        stock.add(newProduct);
    }

    public static void removeProduct(Product product) {
        for(int i = 0; i < stock.size(); i++) {
            if(stock.get(i).getId() == product.getId()) {
                int newQuantity = stock.get(i).getQuantity() - product.getQuantity();
                stock.get(i).setQuantity(newQuantity);
            }
        }
    }

    public void display() {
        for (int i = 0; i < stock.size(); i++) {
            Product product = stock.get(i);
            System.out.println("Item ID: " + product.getId() + " | Product: " + product.getName() + " | Quantity: " + product.getQuantity());

        }
    }

    public void changeProduct(int oldID, Product newProduct) {
        for(int i = 0; i < stock.size(); i++) {
            if(stock.get(i).getId() == oldID) {
                stock.get(i).setDescription(newProduct.getDescription());
                stock.get(i).setId(newProduct.getId());
                stock.get(i).setName(newProduct.getName());
                stock.get(i).setPrice(newProduct.getPrice());
                stock.get(i).setQuantity(newProduct.getQuantity());
            }
        }
    }

    public List<Product> searchProduct(String query){
        List<Product> searches = new ArrayList<Product>();
        for(int i = 0; i < stock.size(); i ++) {
            if(stock.get(i).getName().toLowerCase().contains(query.toLowerCase())){
                searches.add(stock.get(i));
            }
        }
        if(searches.size() != 0) {
            for (int i = 0; i < searches.size(); i++) {
                System.out.println(searches.get(i).getName());
            }
        } else {
            System.out.println("Item not found.");
        }
        return searches;
    }

    public static boolean checkProduct(Product product) {
        for(int i = 0; i < stock.size(); i++) {
            if(stock.get(i).getId() == product.getId() && stock.get(i).getQuantity() <= product.getQuantity()) {
                return true;
            }
        }
        return false;
    }
}
