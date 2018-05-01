import java.util.ArrayList;
import java.util.List;

public abstract class User {

    private int id;
    private String email, password;

    public User(int id, String email, String password){
        setEmail(email);
        setId(id);
        setPassword(password);
    }
    public int getID(){
        return id;
    }

    public String getEmail(){
        return email;
    }

    private String getPassword(){
        return password;
    }

    protected void setId(int newId){
        this.id = newId;
    }

    public void setEmail(String newEmail){
        this.email = newEmail;
    }

    protected void setPassword(String newPassword){
        this.password = newPassword;
    }

    public boolean verifyAccount(String email, String password){
        return (getEmail().equals(email) && getPassword().equals(password));
    }

    public List<Product> searchProduct(String query){
        return Inventory.getInstance().searchProduct(query);
    }
}