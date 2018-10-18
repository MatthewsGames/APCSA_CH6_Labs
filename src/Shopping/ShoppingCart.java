package Shopping;

/**
 * Name: Matthew Sheppard
 * Date: 10/18/18
 * Period: 1
 *
 * Shopping.ShoppingCart.java
 *
 * Represents a shopping cart as an array of items
 */

import java.text.NumberFormat;

public class ShoppingCart
{
    private int itemCount;      // total number of items in the cart
    private double totalPrice;  // total price of items in the cart
    private int capacity;       // current cart capacity
    //TODO 1a) Declare a cart instance variable
    private Item cart[] = new Item[5];


    /**
     * Creates an empty shopping cart with a capacity of 5 items
     */
    public ShoppingCart()
    {
        capacity = 5;
        itemCount = 0;
        totalPrice = 0.0;
        //TODO 1a) Initialize the cart instance variable to the appropriate size

    }

    /**
     * Adds an item to the shopping cart.
     * @param itemName
     * @param price
     * @param quantity
     */
    public void addToCart(String itemName, double price, int quantity)
    {
        //TODO 1b) Complete the addToCart method
        int a = -1;
        for(int i = 0; i < capacity; i++){
            if(cart[i].getName().equals(itemName)){
                a = i;
                break;
            }
        }
        if(a >= 0) {
            cart[a].addMore(quantity);
            totalPrice += price*quantity;
        }
        if(a == -1) {
            for (int i = 0; i < capacity; i++) {
                if (cart[i] == null) {
                    a = i;
                    break;
                }
            }
            if (a >= 0) {
                cart[a] = new Item(itemName, price, quantity);
                totalPrice += price * quantity;
            } else {
                System.out.println("Your cart is already full!");
            }
        }

    }
    public void removeFromCart(String itemName, double price, int quantity)
    {
        //TODO 1b) Complete the addToCart method
        int a = -1;
        for(int i = 0; i < capacity; i++){
            if(cart[i].getName() == itemName){
                a = i;
                break;
            }
        }
        if(a >= 0 && cart[a].getQuantity() >= quantity) {
            cart[a].takeAway(quantity);
            totalPrice -= price*quantity;
            if(cart[a].getQuantity() == 0){
                cart[a] = null;
            }
        }
        else if(a >= 0){
            System.out.println("There is not enough of that item to take away.");
        }
        else {
            System.out.println("That item is not in your cart!");
        }


    }
    //TODO 2b) Complete the getter method getTotalPrice. Remember the getter should not print anything.
    public double getTotalPrice()
    {
        return totalPrice;
    }

    public int getCartLength()
    {
        return cart.length;
    }


    /**
     *
     * @return the contents of the cart together with summary information
     */
    public String toString()
    {
	NumberFormat fmt = NumberFormat.getCurrencyInstance();

	String contents = "\nShopping Cart\n";
	contents += String.format("%-15s%10s%10s%10s","Item","Price","Quantity","Total\n");


	for (int i = 0; i < itemCount; i++)
	{
	    //contents += cart[i].toString() + "\n";
        contents += String.format("%-15s%10.2f%10d%10.2f\n",cart[i].getName(),cart[i].getPrice(), cart[i].getQuantity(),
                                                            (cart[i].getPrice()*cart[i].getQuantity()));

    }

	contents += "\nTotal Price: " + fmt.format(totalPrice);
	contents += "\n";

	return contents;
    }

}
