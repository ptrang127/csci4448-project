import java.util.*;

public class cakeFrostingDecorator {
    public static void main(String[] args) {
        customProduct customCake = new customCake();
        customProduct blueCake = new blueCakeDecorator(new customCake());
        customProduct redCake = new redCakeDecorator(new customCake());
        customProduct redCupCake = new redCakeDecorator(new customCupCake());
        //System.out.println("Regular Cake");
        customCake.make();
        //System.out.println("Red Cake");
        redCake.make();
        redCupCake.make();
        blueCake.make();
    }
}