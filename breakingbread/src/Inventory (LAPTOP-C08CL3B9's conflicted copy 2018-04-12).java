import java.util.*;

public class Inventory {

    private List<Product> stock = new ArrayList<Product>();

    public Inventory() {

    }
    public void addProduct(Product newProduct) {
        stock.add(newProduct);
    }

    public void removeProduct(int oldID) {
        for(int i = 0; i < stock.size(); i++) {
            if(stock.get(i).getId() == oldID) {
                stock.remove(stock.get(i));
            }
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
            if(stock.get(i).getName().contains(query)){
                searches.add(stock.get(i));
            }
        }
        return searches;
    }

}
