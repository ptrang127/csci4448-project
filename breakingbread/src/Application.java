import java.util.*;

public class Application {
    public static ArrayList<User> allUsers = new ArrayList<>();
    public static void main(String[] args) {
        LoginPage login = new LoginPage();
        // global inventory
        Inventory inventory = new Inventory();
        Product kit = new Product(1, 4, "hello kitty kit", "it's a kit", 4);
        inventory.addProduct(kit);


        User user1 = new User(1, "p.trang127@gmail.com", "password");
        allUsers.add(user1);
    }

    public static void Login(String name, String password){
        Iterator<User> itr = allUsers.iterator();
        User currentUser = null;
        while(itr.hasNext()){
            currentUser = itr.next();
            if(currentUser.verifyAccount(name,password)){
                break;
            }
            currentUser = null;
        }
        if(currentUser == null){
            new LoginPage("Username or password is incorrect");
        }
        else {
            System.out.println("Yay");
        }
    }
}

