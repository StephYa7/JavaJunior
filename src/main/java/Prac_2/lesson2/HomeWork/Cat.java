package Prac_2.lesson2.HomeWork;

public class Cat extends Animal{
    int numberOfMustache;
    public Cat() {
        super("unnamed",0);
    }
    public Cat(String name, int age) {
        super(name, age);
    }

    public void makeSound() {
        System.out.println("meow");

    }
}