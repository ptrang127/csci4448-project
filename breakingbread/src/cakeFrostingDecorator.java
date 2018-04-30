import java.util.*;

public class cakeFrostingDecorator {
    public static void main(String[] args) {
        customProduct customCake = new customCake();
        customProduct blueCake = new colorCakeDecorator(new customCake(), "blue");
        customProduct redCake = new colorCakeDecorator(new customCake(), "red");
        customProduct redCupCake = new colorCakeDecorator(new customCupCake(), "red");
        //System.out.println("Regular Cake");
        customCake.make();
        //System.out.println("Red Cake");
        redCake.make();
        redCupCake.make();
        blueCake.make();
    }
}