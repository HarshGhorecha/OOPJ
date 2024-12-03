//wap to print factor of given number
import java.util.Scanner;
public class Factor_M4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entre Number for the Range: ");
        int n =  sc.nextInt();

        for(int i=1; i<=n; i++)
        {
            if(i % 2 == 0)
            {
                System.out.println(i);
            }
        }
        sc.close();
    }    
}
