import java.util.*;

public class Admin extends User{

    /*TO-DO: Replace this so that we can access the inventory
    initialised when running the application. Also implement singleton
    design pattern.
    Figure out viewAccount method to find account from userlist and return
    User details.
     */
    Inventory inventory;

   /* public User viewAccount(int userId) {
        // mysql code to print out user

    }*/
    /*
    TO-DO: Find User account in userlist using userID and
    set values to default and/or delete
    */
    public int removeAccount(int userId){
        //
        return userId;
    }

    public int addProduct(Product newProduct){
        inventory.addProduct(newProduct);
        return 0;
    }

    public int changeProduct(int oldId, Product newProduct){
        inventory.changeProduct(oldId, newProduct);
        return oldId;
    }

    /*
     TO-DO: Find Desired product from ProductList
     Then modify by calling addDeal method found in Product class.
     Figure out how to use lists created at the start of application
     and be able to modify them to keep intended functionality.
    */
    public int addDeal(int productId, Deal deal){
        //List<Product> = inventory.searchProduct()
        //Product.addDeal(deal);
        return productId;
    }

}