public class cakefrostingDecorator{
    public static void main(String[] args){
        customProduct = new customCake();
        customProduct redCake = new frostingColor(new customCake("red"));
    }
}