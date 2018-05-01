import java.util.*;

public class Application {
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<Admin> admins = new ArrayList<>();
    private static int currentUser = 0;
    private static int ID = 1;
    private static final String COMPANY_DOMAIN = "breadbreaker.com";

    private static Boolean authenicate(String email){
        String[] parts = email.split("@");
        if(parts.length == 2){
            String[] domain = parts[1].split("\\.");
            if(domain.length == 2 && !parts[0].isEmpty() && !domain[0].isEmpty() && !domain[1].isEmpty()){
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Customer> getCustomers(){
        return customers;
    }

    public static void main(String[] args) {
        admins.add(new Admin(1,"Fred@breadbreaker.com","password"));
        new LoginPage();


    }

    public static Boolean login(String email, String password){
        if(!authenicate(email)){
            return false;
        }

        Iterator<Customer> itr = customers.iterator();
        Customer temp = null;
        currentUser = 0;

        while(itr.hasNext()){
            temp = itr.next();
            if(temp.verifyAccount(email,password)){
                break;
            }
            temp = null;
            currentUser++;
        }

        if(temp == null){
            Iterator<Admin> aitr = admins.iterator();
            Admin atemp = null;
            currentUser = 0;
            while(aitr.hasNext()){
                atemp = aitr.next();
                if(atemp.verifyAccount(email,password)){
                    break;
                }
                atemp = null;
                currentUser++;
            }

            if(atemp == null){
                return false;
            }
            else {
                new MainPage(admins.get(currentUser));
                return true;
            }
        }
        else {
            new MainPage(customers.get(currentUser));
            return true;
        }
    }

    public static String signup(String email, String password, String address) {
        if(!authenicate(email)){
            return "Bad Email";
        }
        Iterator<Customer> itr = customers.iterator();
        Customer temp = null;
        currentUser = 0;
        while(itr.hasNext()){
            temp = itr.next();
            if(temp.getEmail().equals(email)){
                temp = null;
                return "Email already taken";
            }
            temp = null;
            currentUser++;
        }
        temp = new Customer(ID++, email, password, address);
        customers.add(currentUser,temp);
        new MainPage(customers.get(currentUser));
        return "";
    }

    public static String adminsignup(String email, String password) {
        if(!authenicate(email)){
            return "Bad Email";
        }
        else if(!email.split("@")[1].equals(COMPANY_DOMAIN)){
            return "Bad domain";
        }
        Iterator<Admin> itr = admins.iterator();
        Admin temp = null;
        currentUser = 0;
        while(itr.hasNext()){
            temp = itr.next();
            if(temp.getEmail().equals(email)){
                temp = null;
                return "Email already taken";
            }
            temp = null;
            currentUser++;
        }
        temp = new Admin(ID++, email, password);
        admins.add(currentUser,temp);
        new MainPage(admins.get(currentUser));
        return "";
    }

    public static void removeAccount(int userId){
        Iterator<Customer> itr = customers.iterator();
        Customer thisUser = null;
        while(itr.hasNext()) {
            thisUser = itr.next();
            if (thisUser.getID() == userId) {
                break;
            }
        }
        customers.remove(thisUser);
    }

    public static User searchAccount(int userId){
        Iterator<Customer> itr = customers.iterator();
        Customer thisUser = null;
        while(itr.hasNext()) {
            thisUser = itr.next();
            if (thisUser.getID() == userId) {
                break;
            }
        }
        return thisUser;
    }
}

