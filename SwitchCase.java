import java.util.Scanner;
public class SwitchCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Choose Your Number Beetwen 1 to 5: ");
        int num = sc.nextInt();

        switch(num)
        {
            case 1 : System.out.println("Choosed Number is: " + num);
            break;

            case 2 : System.out.println("Choosed Number is: " + num);
            break;

            case 3 : System.out.println("Choosed Number is: " + num);
            break;

            case 4 : System.out.println("Choosed Number is: " + num);
            break;

            case 5 : System.out.println("Choosed Number is: " + num);
            break;

            default: System.out.println("Invalid Choose Please Choose Beetwen 1 to 5");
            break;
            
        }

        sc.close();
    }
    
}
