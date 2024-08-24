import java.util.*;

public class Sumname {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				System.out.println("First name : ");
				String name = sc.nextLine();
				System.out.println("second name : ");
				String  sname = sc.nextLine();
				System.out.print("full name : " + (name+sname));
	}
}