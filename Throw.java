public class ThrowKeyword 
{
    public static void main(String args[])
    {
        int i = 20;
        int j = 0;

        try
        {
            j = 18/i;
            if(j == 0)
                //if you want print some message write int Constructor "|"
                throw new ArithmeticException("I dont want to print zero");
        }
        catch(ArithmeticException e)
        {
            j = 18/1;
            System.out.println("That is the default output "+ e);
        }
        
        catch(Exception e)
        {
            System.out.println("Somthing went wrong..."+ e);
        }

        System.out.println(j);

        System.out.println("The end");
    }
}
