public class ExceptionHandling 
{
    public static void main(String[] args)
    {
        try 
        {
            checkAge(15);
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            System.out.println("checkAge is complete");
        }
    }
    // write out of void main() its better s
    public static void checkAge(int age)throws Exception
    {
        if(age < 18)
        {
            throw new Exception("Age is below 18");
        }
    }
}
