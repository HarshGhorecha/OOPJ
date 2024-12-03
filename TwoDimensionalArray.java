import java.util.Scanner;
class TwoDimensionalArray
{
    public static void main(String args[])
    {
        int size;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of an array: ");
        size = sc.nextInt();

        int[][] marks = new int[size][size];
        
        for(int i=0; i<marks.length; i++)
        {
            for(int j=0; j<marks[i].length; j++)
            {
                System.out.println("Enter the marks: ");
                marks[i][j]= sc.nextInt();
            }
        }

        for(int i=0; i<marks.length; i++)
        {
            for(int j=0; j<marks[i].length; j++)
            {
                System.out.print("marks[" +i+ "][" +j+ "]: "+marks[i][j] +"\t");
            }
        }
        

        sc.close();

    }
    
}
