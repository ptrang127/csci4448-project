import java.util.ArrayList;
import java.util.List;

public class User {

    private int id, privilege;
    private String email, password;

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

    /*public void setPrivilege(int privilege){
        this.privilege = privilege;
    }*/

    private void setPassword(String newPassword){
        this.password = newPassword;
    }

    public boolean verifyAccount(){
        return (this.id != 0);
    }

    public void forgotPassword(){

    }

    public List<Product> searchProduct(String query){

    }
}