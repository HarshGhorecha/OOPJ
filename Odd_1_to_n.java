// wap print 1 to n odd number 
import java.util.Scanner;
public class Odd_1_to_n {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number for the Range:");
        int n = sc.nextInt();

        for(int i=0; i<=n; i++)
        {
            if(i % 2 == 1)
            {
                System.out.println(i);
            }
        }
        sc.close();
    }
    
}
