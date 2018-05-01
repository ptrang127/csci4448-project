import java.util.*;

public class Inventory {

    // singleton
    private static Inventory single_instance = null;
    private static List<Product> stock = new ArrayList<>();

    private Inventory() {
        stock.add(new Product(1, 20, "Cake", "A basic vanilla cake", "img/cake.jpg",4));
        stock.add(new Product(2, 48, "Cupcake", "Batches of fresh cupcakes that come in packs of 4", "img/cupcake.jpg",4));
        stock.add(new Product(3, 30, "Muffin", "Delicious fluffy muffin", "img/muffin.jpg",4));
        stock.add(new Product(4, 120, "Donut", "Creamy donuts", "img/donut.jpg",4));
        stock.add(new Product(5, 25, "Crepe", "Thin pancakes with creamy toppings", "img/crepe.jpg",4));
        stock.add(new Product(6, 40, "Pie", "Hard crust pies", "img/pie.jpg",4));

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

    public static void deleteProduct(Product product) {
        for(int i = 0; i < stock.size(); i++) {
            if(stock.get(i).getId() == product.getId()) {
                stock.remove(i);
                break;
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
        if(searches.size() == 0) {
            System.out.println("Item not found.");
        }
        return searches;
    }

    public static boolean checkProduct(Product product) {
        for(int i = 0; i < stock.size(); i++) {
            if(stock.get(i).getId() == product.getId() && stock.get(i).getQuantity() >= product.getQuantity()) {
                return true;
            }
        }
        return false;
    }

    public Product getProduct(int Id){
        for(int i = 0; i < stock.size(); i++) {
            if(stock.get(i).getId() == Id) {
                return stock.get(i);
            }
        }
        throw new IndexOutOfBoundsException();
    }
}
