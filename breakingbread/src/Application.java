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

        //new LoginPage();
        currentUser = user1;
        new MainPage(user1);
    }

    public static void Login(String name, String password){
        Iterator<User> itr = allUsers.iterator();
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
            new MainPage(currentUser);
        }
    }

    public static void Search(String query){
        new MainPage(currentUser, currentUser.searchProduct(query));
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

