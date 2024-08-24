import java.util.*;

public class VowelCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
       
        char firstChar = Character.toLowerCase(name.charAt(0));
       
        if (firstChar == 'a' || firstChar == 'e' || firstChar == 'i' ||
            firstChar == 'o' || firstChar == 'u') {
            System.out.println("The first character of the name is a vowel.");
        } else {
            System.out.println("The first character of the name is not a vowel.");
        }
        
 
    }
}