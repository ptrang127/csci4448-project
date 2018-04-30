import java.util.*;

public class Application {
    public static ArrayList<User> allUsers = new ArrayList<>();
    private static User currentUser = null;
    public static void main(String[] args) {
        // global inventory
        Inventory inventory = Inventory.getInstance();
        Product kit = new Product(1, 4, "hello kitty kit", "it's a kit", 4);
        inventory.addProduct(kit);

        User user1 = new User(1, "p.trang127@gmail.com", "password");
        allUsers.add(user1);

        currentUser = user1;
        new MainPage(user1);
        //new LoginPage();
    }

    public static Boolean Login(String name, String password){
        Iterator<User> itr = allUsers.iterator();
        while(itr.hasNext()){
            currentUser = itr.next();
            if(currentUser.verifyAccount(name,password)){
                break;
            }
            currentUser = null;
        }
        if(currentUser == null){
            return false;
        }
        else {
            new MainPage(currentUser);
            return true;
        }
    }

    public static List<Product> Search(String query){
        return currentUser.searchProduct(query);
    }
}

