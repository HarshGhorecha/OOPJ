//lab 10 A1 //
/* A 1 Write a program to demonstrate Arithmetic Exception and ArrayIndexOutOfBounds 
Exception using try-catch block. [A] */ 

import java.util.*;

public class A1{
	public static void main(String[] args) {
		try{

			int a = 4;
			int b = 0;
			int c = a/b;

			System.out.println("c :"+c);
		}
		catch(ArithmeticException e)
		{
			System.out.println("ArithmeticException");
		}

		try
		{
			int[] a = {1,2,3,4,5,6,7,8};

			System.out.println("index of array: "+a[8]);
		}
		catch(ArrayIndexOutOfBoundsException  aiob)
		{
			System.out.println("ArrayIndexOutOfBounds");
		}		
	}
}

