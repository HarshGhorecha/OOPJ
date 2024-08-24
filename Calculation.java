import java.util.*;

public class Calc {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("a");
		int a = sc.nextInt();
		System.out.println("b");
		int b = sc.nextInt();
		System.out.println("Addition :"+ (a+b));
		System.out.println("Subtraction :"+ (a-b));
		System.out.println("Multiplication :"+ (a*b));
		System.out.println("division :"+ (a/b));
		System.out.println("Reminder :"+ (a%b));
	}
}