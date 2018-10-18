package Sales;
/**
 * Name: Matthew Sheppard
 * Date: 10/18/18
 * Period: 1
 *
 * Sales.Sales.java
 *
 * Reads in and stores sales for each of 5 salespeople.  Displays
 * sales entered by salesperson id and total sales for all salespeople.
 */
import java.util.Arrays;
import java.util.Scanner;

public class Sales
{
    public static void main(String[] args)
    {
        System.out.print("Enter number of Salespeople: ");
        Scanner scan = new Scanner(System.in);

        //TODO 4) Prompt the user for the number of sales people that they need to enter
        int num = scan.nextInt();

        //TODO 4) and modify the program to create an appropriately sized array.

        
        final int SALESPEOPLE = num;
        int[] sales = new int[SALESPEOPLE];
        int sum;

        for (int i=0; i < sales.length; i++)
        {
            System.out.print("Enter sales for salesperson " + (i + 1) + ": ");
            sales[i] = scan.nextInt();
        }
        //print the array for verification
        //System.out.println(Arrays.toString(sales));

        System.out.println("\nSalesperson   Sales");
        System.out.println("--------------------");
        sum = 0;
        for (int i=0; i < sales.length; i++)
        {
            System.out.println("\t " + (i + 1) + "\t\t\t" + sales[i]);
            sum += sales[i];
        }

        System.out.println("\nTotal sales: " + sum);

        //TODO 1b) Use your average method to print the average sales
        System.out.println("\nAverage sales: " + average(sales));

        //TODO 2b) Use your indexOfMax method to print the index of the best sales person
        //TODO 2b) and the sales amount for that sales person.
        System.out.println("\nHighest Salesperson was Salesperson " + (indexOfMax(sales) + 1));
        System.out.println("with " + sales[indexOfMax(sales)] + " sales.");

        //TODO 3b) Do the same for the worst sales person
        System.out.println("\nLowest Salesperson was Salesperson " + (indexOfMin(sales) + 1));
        System.out.println("with " + sales[indexOfMin(sales)] + " sales.");


    }

    public static double average(int[] arr) throws IllegalStateException
    {
        //TODO 1a) compute and return the average of arr
        //Be sure to use the length instance variable and you may assume that the array is full.
        //If the array does not have at least 1 element in it, throw an IllegalStateException
        double total = 0;
        if(arr.length == 0){
            throw new IllegalStateException();
        }
        for(int i = 0; i < arr.length; i++){
            total += arr[i];
        }
        return total/arr.length;
    }

    public static int indexOfMax(int[] arr)
    {
        //TODO 2a) find and return the index of the max value in arr
        int max = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > arr[max]){
                max = i;
            }
        }
        return max;
    }
    public static int indexOfMin(int[] arr)
    {
        //TODO 2a) find and return the index of the min value in arr
        int min = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < arr[min]){
                min = i;
            }
        }
        return min;
    }


}
