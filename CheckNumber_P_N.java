// check given number is positive or not and print message
import java.util.Scanner;
public class CheckNumber_P_N {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int number = sc.nextInt();

        if(number > 0)
        {
            System.out.println(number + " Number is Positive");
        }
        else if(number < 0)
        {
            System.out.println(number + " Number is Negative");
        }
        else
        {
            System.out.println(number + " Number is Zero");
        }
        sc.close();
    }
}
