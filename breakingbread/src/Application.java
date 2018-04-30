import java.util.*;

public class Application {
    public static ArrayList<User> allUsers = new ArrayList<>();
    private static User currentUser = null;
    private static int ID = 1;
    public static void main(String[] args) {
        // global inventory
        Inventory inventory = Inventory.getInstance();
        Product kit = new Product(1, 4, "hello kitty kit", "it's a kit", 4);
        inventory.addProduct(kit);

        User user1 = new User(ID++, "p.trang127@gmail.com", "password");
        allUsers.add(user1);

        new LoginPage();
    }

    public static Boolean login(String name, String password){
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

    public static String signup(String name, String password) {
        Iterator<User> itr = allUsers.iterator();
        while(itr.hasNext()){
            currentUser = itr.next();
            if(currentUser.getEmail().equals(name)){
                currentUser = null;
                return "Username already taken";
            }
        }
        currentUser = new User(ID++, name, password);
        allUsers.add(currentUser);
        new MainPage(currentUser);
        return "";
    }

    public static List<Product> Search(String query){
        return currentUser.searchProduct(query);
    }

    public void addAccount(User newUser){
        allUsers.add(newUser);
    }

    public static void removeAccount(int userId){
        Iterator<User> itr = allUsers.iterator();
        User thisUser = null;
        while(itr.hasNext()) {
            thisUser = itr.next();
            if (thisUser.getID() == userId) {
                break;
            }
            //thisUser = null;
        }
        itr.remove();
    }

    public static User searchAccount(int userId){
        Iterator<User> itr = allUsers.iterator();
        User thisUser = null;
        while(itr.hasNext()) {
            thisUser = itr.next();
            if (thisUser.getID() == userId) {
                break;
            }
            //thisUser = null;
        }
        return thisUser;
    }
}

