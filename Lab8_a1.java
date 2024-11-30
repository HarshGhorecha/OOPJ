/*The abstract vegetable class has three subclasses named Potato, Brinjal and Tomato.
Write a java program that demonstrates how to establish this class hierarchy. Declare
one instance variable of type String that indicates the color of a vegetable. Crete and
display instances of these objects. Override the toString() method of object to return a
string with the name of vegetable and its color. 
 */

abstract class Vegetable
{
    protected String Color;

    Vegetable(String Color)
    {
        this.Color = Color;
    }

    public abstract String toString();
}

class Potato extends Vegetable
{
    Potato(String Color)
    {
        super(Color);

    }
    @Override
    public String toString()
    {
        return "Vegetable: Potato, Color: " + Color;
    }
}

class Brinjal extends Vegetable
{
    Brinjal(String Color)
    {
        super(Color);

    }
    @Override
    public String toString()
    {
        return "Vegetable: Brinjal, Color: " + Color;
    }
}

class Tomato extends Vegetable
{
    Tomato(String Color)
    {
        super(Color);

    }
    @Override
    public String toString()
    {
        return "Vegetable: Tomato, Color: " + Color;
    }
}

public class Lab8_1 {
    public static void main(String args[])
    {
        Potato p = new Potato("brown");
        System.out.println(p.toString());

        Brinjal b = new Brinjal("Purple");
        System.out.println(b.toString());

        Tomato t = new Tomato("Red");
        System.out.println(t.toString());

        
    }
}
