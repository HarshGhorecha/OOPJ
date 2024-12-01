/*
can interfaces extends? if yes explain with appropriate example - [4 MARKS]
=> yes,an interfaces in java can be extended.
=>an Interface can extend anouthor interface or multiple interfaces using "EXTENDS" keyword
=>this allows a new interface to inherit the abstract method of "PARENT INTERFACE" 
=>the CHILD INTERFACE can also declare additional methods

Explanation:

Animal Interface: Declares methods eat() and sleep().

Dog Interface: Extends Animal and adds a new method bark().

Labrador Class: Implements the Dog interface and provides implementations for all three methods (eat(), sleep(), and bark()).

Main Class: Demonstrates creating an instance of Labrador and calling its methods. */

interface Animal
{
    void eat();
    void sleep();
}

interface Dog extends Animal // use "extends" keyword not "implements"
{
    void bark();
}

class Labrador implements Dog{
    public void eat(){
        System.out.println("Labrador eat foods");
    }
    public void sleep(){
        System.out.println("Labrador sleep");
    }
    public void bark(){
        System.out.println("Labrador barks");
    }
}

public class InterfaceExtends
{
    public static void main(String[] args) {
        
        Labrador lb = new Labrador();
        lb.eat();
        lb.sleep();
        lb.bark();
    }
}
