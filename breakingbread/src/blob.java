import java.util.*;
public class blob {

    public static void main(String[] args) {

        // global inventory
        Inventory inventory = new Inventory();
        Product kit = new Product(1, 4, "hello kitty kit", "it's a kit", 4);
        inventory.addProduct(kit);

        // global list of users
        ArrayList<User> allUsers= new ArrayList<>();

        // global list of admins
        ArrayList<Admin> allAdmins = new ArrayList<>();

        User user1 = new User(1, "p.trang127@gmail.com", "password");
        System.out.println(user1.searchProduct("hello kitty", inventory));

    }

}