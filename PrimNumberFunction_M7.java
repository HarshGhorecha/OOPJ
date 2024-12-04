/ * Define function. Write a function to check whether given number is prime or not
====================================================================================
FUNCTION DEFINATION: " A function in Java is a block of code designed to perform a specific task. 
Functions promote code reusability and modular programming. 
In Java, a function is also referred to as a method. "
====================================================================================
 import java.util.Scanner;

public class PrimNumberFunction_M7  
{
    public static boolean isPrime(int number)
    {
        {
           if(number <= 1)
            {
                System.out.println("Number is <= 1");
                return false;
            }
        }

        for(int i=2; i<= Math.sqrt(number); i++ )
        {
            if(number % i == 0)
            {
                System.out.println("Number is Divisible Not Prime");
                return false;
            }
        }
    return true;
}
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number: ");
        int number = sc.nextInt();
        
        if(isPrime(number))
        {
            System.out.println(number + " Number is Prime");
        }
        else
        {
            System.out.println(number + " Number is not Prime");
        }
        sc.close();
    }
}    


*/
