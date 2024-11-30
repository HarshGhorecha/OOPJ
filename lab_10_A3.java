// lab 10 A 3 //

/* A 3 Write a java program to create Custom Exception ( DarshanUniException). Catch this 
exception using throw clause and print appropriate message. [A] */ 
import java.util.*;

class DarshanUniException extends Exception {
    public DarshanUniException(String s)
    {
        // Call constructor of parent Exception
        super(s);
    }
}


public class A103CustomException
{
	public static void studentscore(int x)throws DarshanUniException
	{
		if(x<30)
		{
			throw new DarshanUniException("not eligible score : score less than 30");
		}
		else
		{
			throw new DarshanUniException("eligible");
		}
	}
	public static void main(String[] args) {
		
		int getmarks=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Marks:");
		getmarks = sc.nextInt();

		try
		{
			studentscore(getmarks);

		}

		catch(DarshanUniException d)
		{
			System.out.println("DarshanUniException : "+ d.getMessage());
		}
	}
}


