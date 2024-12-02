public class ThrowsDemo {
    public static void main(String[] args) 
    {
        try
        {
            checkNumber(-18);
        }  
        catch(Exception e)
        {
            System.out.println("Exception caught:"+e.getMessage());
        }  
    }
            
    public static void checkNumber(int num) throws Exception
    {
        if(num < 0)
        {
            throw new Exception("Negatvie number not allow");
        }
    }
}
