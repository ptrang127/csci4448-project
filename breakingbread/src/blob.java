import java.util.*;
public class blob {

    public static void main(String[] args) {

        // global inventory
        Inventory inventory = Inventory.getInstance();

        // global list of users
        ArrayList<User> allUsers = new ArrayList<>();

        // global list of admins
        ArrayList<Admin> allAdmins = new ArrayList<>();
        Product kit = new Product(1, 20, "Cakes", "A basic vanilla cake", 4);
        Customer user1 = new Customer(1, "p.trang127@gmail.com", "password", "street");
        Admin admin1 = new Admin(1, "me@breadbreaker.com", "password");
       //  user1.searchProduct("ca", inventory);
        user1.addItem(kit);
        inventory.display();
        user1.checkout();
        System.out.println("checkout test");
        inventory.display();
        admin1.changeProduct(1, new Product(1, 11, "Not a cake", "we changed this", 2));
        System.out.println("admin modify product test");
        inventory.display();
        admin1.addProduct(kit);
        System.out.println("admin modify product test");
        inventory.display();
    }

}