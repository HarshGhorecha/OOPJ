/*In a company an employee is paid as under:
=> If his basic salary is less than Rs.1500, then HRA = 10% of basic salary and DA = 90% of basic salary.
=> If his salary is either equal to or above Rs. 1500, then HRA = Rs. 500 and DA = 98% of
basic salary.
Employee's salary is input through the keyboard, 
write a program to find his "gross salary". */
import java.util.Scanner;
public class GrossSalary_M7 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Basic Salary: ");  
        double basicsalary = sc.nextDouble();
        
        double hra,da,grosssalary;

        if(basicsalary < 1500)
        {
            hra = 0.10 * basicsalary;
            da = 0.90 * basicsalary;
        }
        else
        {
            hra = 500;
            da = 0.98 * basicsalary;
        }
        
        grosssalary = hra + da + basicsalary;

        System.out.print("Gross Salary: Rs. " + grosssalary);
        sc.close();
    }    
}
