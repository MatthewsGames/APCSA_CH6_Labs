package Shopping;
import java.util.Scanner;
public class ShopTest {
    public static void main(String[] args){
        while (true){
            Scanner scan = new Scanner(System.in);
            ShoppingCart cart = new ShoppingCart();
            System.out.println();
            System.out.println("Welcome to the ShoppingCart3000!");
            System.out.println("1.Add items to cart");
            System.out.println("2.Remove items from cart");
            System.out.println("3.See items in cart");
            System.out.println("4.Quit");
            System.out.println("What would you like to do?: ");
            int num = scan.nextInt();
            if(num == 1){
                System.out.println("What would you like to buy?");
                String name = scan.next();
                System.out.println("How much does it cost?");
                double price = scan.nextDouble();
                System.out.println("How many do you want?");
                int quantity = scan.nextInt();
                cart.addToCart(name, price, quantity);
            }
            else if(num == 2){
                System.out.println("What would you like to remove?");
                String name = scan.nextLine();
                System.out.println("How much does it cost?");
                double price = scan.nextDouble();
                System.out.println("How many do you want?");
                int quantity = scan.nextInt();
                cart.removeFromCart(name, price, quantity);
            }
            else if(num == 3){
                System.out.println(cart);
            }
            else if(num == 4){
                break;
            }
        }
    }
}
