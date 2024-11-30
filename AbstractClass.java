abstract class SuperCar
{
    public abstract double getAverage();
    public abstract int getSpeed();
}
class BuggatiChiron extends SuperCar
{
    public double getAverage()
    {
        return 8.0;
    }

    public int getSpeed()
    {
        return 490;
    }
}

class SSC_Tutara extends SuperCar
{
    public double getAverage()
    {
        return 12.0;
    }

    public int getSpeed()
    {
        return 450;
    }
}

public class AbstractClassEx
{
    public static void main(String args[])
    {
       // SuperCar sc = new BuggatiChiron(); also access methods like this to do Dynamic dispatch method

       BuggatiChiron bbt = new BuggatiChiron();
       System.out.println("Buggati Chiron's Avg per Gallon: "+ bbt.getAverage());
       System.out.println("Buggati Chiron's Max Speed is:"+ bbt.getSpeed());
       System.out.println();

       SSC_Tutara ssct = new SSC_Tutara();
       System.out.println("SSC_Tutara's Avg per Gallon: "+ ssct.getAverage());
       System.out.println("SSC_Tutara's Max Speed is: "+ ssct.getSpeed());
        
    }
}
