public class TryCatch
{
    public static void main(String[] args) {
        
        int i = 0;
        int j = 0;

        int marks[] = new int[5];

        String str = null;

        try
        {
            //this will throw ArithmeticException
            j = 18/i;

            System.out.println(marks[1]);
            //this statement will throw ArrayIndexOutOfBounds
            //System.out.println(marks[5]); CommentOut because of the if try block caught error not run other remaning statements

            //this will throw NullPointerException
            System.out.println(str.length());

        }
        catch(ArithmeticException e)
        {
            System.out.println("Cannot divide by zero: "+ e);
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Custom Message: Accessing index out of the array... " + e);
        }
        //Exeption is Parent class it can handle all the Exception...
        // if  you dont know which exwption will throw that time use Exception 
        catch(Exception e)
        {
            System.out.println("Somthing went wrong.. " + e);
        }

        System.out.println(j);

        System.out.println("The End!!!");
    }
}
