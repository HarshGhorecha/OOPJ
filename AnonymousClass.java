class Anonymous
{
    public void Show()    
    {
        System.out.println("IN THE SHOW METHOD OF THE ANONYMOUS CLASS");
    }
}

public class AnonymousClass
{
    public static void main(String args[])
    {
        Anonymous A = new Anonymous()
        {
            @Override
            public void Show()
            {
                // super.Show(); -> IT'S CALLED ANONYMOUS CLASS METHOS WHICH IS OVERRIDE
                System.out.println("IN THE MAIN CLASS'S ANONYMOUS CLASS SHOW METHOD");
            }
        };

        A.Show();// METHOD SHOW OF INNER ANONYMOUSE CLASS
    }
}
