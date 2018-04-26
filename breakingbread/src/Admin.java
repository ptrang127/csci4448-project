import java.util.*;

public class Admin extends User{

    Inventory inventory = new Inventory();

   /* public User viewAccount(int userId) {
        // mysql code to print out user

    }*/

    public int removeAccount(int userId){
        //
        return userId;
    }

    public int addProduct(Product newProduct){
        inventory.addProduct(newProduct);
        return 0;
    }

    public int removeProduct(int oldId){
        inventory.removeProduct(oldId);
        return oldId;
    }

    public int changeProduct(int oldId, Product newProduct){
        inventory.changeProduct(oldId, newProduct);
        return oldId;
    }

    public int addDeal(int productId, Deal deal){
        //Product.addDeal(deal);
        return productId;
    }

}