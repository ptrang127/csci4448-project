import java.util.ArrayList;
import java.util.List;
import Product.java;

public class User {

    private int id, privilege;
    private String email, password;


    public User(int id, int privilege, String email, String password){
        setEmail(email);
        setID(id);
        setPassword(password);
        setPrivilege(privilege);
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

    private void setID(int id){
        this.id = id;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPrivilege(int privilege){
        this.privilege = privilege;
    }

    private void setPassword(String password){
        this.password = password;
    }

    public bool verifyAccount(){
        return (this.id != 0);
    }

    public int forgotPassword(){

    }

    public ArrayList<Product> searchProduct(String query){

    }
}