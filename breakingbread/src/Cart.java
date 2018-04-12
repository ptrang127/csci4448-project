import java.util.*; //just to see the colors on intellij 
public class Cart{
    //if add to items = y
    public float price = 0;
    Map<String, Product> items = new HashMap<String, Product>();
    public void addItem(Product product){
        items.put(product.getName(), product);
        System.out.println("Item Successfully Added to Cart");
        //possible addition of continue shopping or checkout on display
    }

    public float getPrice() {
        Set currentCart = items.entrySet(); //cool built in Java ish to make a set from the hashmap idk if this should be here though
        Iterator<String> i = currentCart.iterator(); //this should work for the interator, length of the items
        while(i.hasNext()) //possibly create a new iterator
        {
            //iterate through all items in hashmap
            //for every item
            price += (items.get(i.next()).getDiscountPrice());
        }
        System.out.println(price);
        return price;
    }
    //items is our Hashmap
    //Display all items in hashmap when in items page
    //there should also be a quantity variable
    //if statement
    //if in stock add to items, add item and price to hashmap
    //display message 'Item successfully added to items
    //else display error
    //create 'total' variable, the sum of th price of all the items in the items
    //display menu to continue shopping(optional)
}
