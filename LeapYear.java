//any year enter through keyboard.. wap whether enterd year is leapyear or not
import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter year: ");
        int year = sc.nextInt();

        if(year % 4 ==0)
        {
            if(year % 100 != 0 || year % 400 == 0)
            {
                System.out.println(year +" is LeapYear");
            }
            else
            {
                System.out.println(year + "is not LeapYear");
            }
        }
        else
        {
            System.out.println(year + " is not LeapYear");
        }
        sc.close();     
    }
    
}
