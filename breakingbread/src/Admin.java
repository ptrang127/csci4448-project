public class Admin extends User{

    public User viewAccount(int userId) {
        // mysql code to print out user
    }

    public int removeAccount(int userId){
        //
    }

    public int addProduct(Product newProduct){

    }

    public int removeProduct(int oldId){

    }

    public int changeProduct(int oldId, Product newProduct){

    }

    public int addDeal(int productId, Deal deal){
        Product.addDeal(deal);
    }
}