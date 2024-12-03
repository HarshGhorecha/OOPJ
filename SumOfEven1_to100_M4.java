public class SumOfEven1_to100_M4
{
    public static void main(String[] args) {
        int sum = 0;

        for(int i =1; i<=100; i++)
        {
            if(i % 2 == 0)
            {
                sum = sum + i;
            }
        }
        System.out.println("SUM OF 1 TO 100 EVEN NUMBER IS: "+ sum);
    }
}
