public class shoppingCart{
    //if add to cart = y
    //;
    Map<String, int, int > cart = new HashMap();
    iterator i = set.iterator
    void private setCart{
        if(addToCart()){
            cart.put(product.name, product.price, product.quantity);
            System.out.println("Item Successfully Added to Cart");
            //possible addition of continue shopping or checkout on display
        }
    }
    Hashmap public getCart{
        while(i.hasNext()){
            //something with an interator
            //to iterate and then print all items in cart
        }

    }
    void protected setTotal{ //probably needs to be accessed in getTotal method
        while(i.hasNext()) //possibly create a new iterator
        {
            //iterate through all items in hashmap
            //for every item
            total += (item*quantity);
        }
    }
    int public getTotal{
        System.out.println(total);
        return total;

    }
    //cart is our Hashmap
    //Display all items in hashmap when in cart page
    //there should also be a quantity variable
    //if statement
    //if in stock add to cart, add item and price to hashmap
    //display message 'Item successfully added to cart
    //else display error
    //create 'total' variable, the sum of th price of all the items in the cart
    //display menu to continue shopping(optional)
}
