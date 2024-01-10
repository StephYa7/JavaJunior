package Prac_2.lesson2.HomeWork;

public class Dog extends Animal {
    boolean isGoodBoy = true;

    public Dog() {
        super("unnamed", 0);
    }

    public Dog(String name, int age) {
        super(name, age);
    }

    public void bork() {
        System.out.println("woof");
    }

}