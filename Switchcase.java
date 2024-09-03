import java.util.*;
class Switchcase
{
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);

		int a=sc.nextInt();
		int b=sc.nextInt();
		char ch=sc.next().charAt(0);


		switch(ch)
		{
			case'+':
			System.out.println("addition:"+(a+b));
			break;

			case'-':
			System.out.println("subtraction:"+(a-b));
			break;

			case'*':
			System.out.println("multiplication:"+(a*b));
			break;

			case'/':
			System.out.println("division:"+(a/b));
			break;
			default:
			System.out.println("nothing to match");
			break;
		}

	}
}
