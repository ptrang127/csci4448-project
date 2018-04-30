import java.util.ArrayList;
import java.util.List;

public class User {

    private int id, privilege;
    private String email, password;
    private Cart order;

    public User() {

    }

    public User(int id, /*int privilege,*/ String email, String password){
        setEmail(email);
        setId(id);
        setPassword(password);
        //setPrivilege(privilege);
    }
    public int getID(){
        return id;
    }

    public String getEmail(){
        return email;
    }

    public int getPrivilege(){
        return privilege;
    }

    private String getPassword(){
        return password;
    }

    private void setId(int newId){
        this.id = newId;
    }

    public void setEmail(String newEmail){
        this.email = newEmail;
    }

    public Cart getCart(){return order;}

    public void setCart(Cart order){this.order = order;}

    /*public void setPrivilege(int privilege){
        this.privilege = privilege;
    }*/

    private void setPassword(String newPassword){
        this.password = newPassword;
    }

    public boolean verifyAccount(String name, String password){
        return (getEmail().equals(name) && getPassword().equals(password));
    }

    public void forgotPassword(){

    }

    public List<Product> searchProduct(String query){
        return Inventory.getInstance().searchProduct(query);
    }
}