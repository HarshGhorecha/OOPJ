//WAP to calculate the sum of positive numbers using continue statement.
import java.util.Scanner;
public class Calac_sum_break_con_m4 {
    public static void main(String[] args) {
        int sum = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER NUMBERS TO CALCULATE THE SUM OF POSITIVE NUMBER... [ENTER 0 TO STOP]");

        while(true)
        {
            System.out.println("ENTER THE NUMBER: ");
            int num = sc.nextInt();

            if(num == 0)
            {
                break; // exit the loop
            }

            else if(num < 0)
            {
                continue; //skip negative number
            }

            sum += num;


        }
        System.out.println("SUM OF ENTERED POSITIVE NUBERS IS: "+ sum);
        sc.close();
    }
}
