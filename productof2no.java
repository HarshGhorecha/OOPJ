import java.util.*;

public class Product {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first number :");
		double Number1 = sc.nextDouble();
		System.out.println("Enter Second number :");
		double Number2 = sc.nextDouble();
		double product = (Number1*Number2);
		System.out.println("The product of two numbers:" + product);
	}
}