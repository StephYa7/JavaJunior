package Prac_2.lesson2.HomeWork;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws IllegalAccessException,InvocationTargetException {
        Dog dog1 = new Dog("dog1", 5);
        Dog dog2 = new Dog();
        Cat cat1 = new Cat("cat1", 3);
        Cat cat2 = new Cat();
        Animal[] animals = new Animal[]{dog1, dog2, cat1, cat2};

        for (Animal animal : animals) {
            Field[] fields = animal.getClass().getDeclaredFields();
            Field[] fieldsFromSuperClass = animal.getClass().getSuperclass().getDeclaredFields();
            System.out.println("---");
            for (Field field : fields) {
                System.out.println(field.getName() + " " + field.get(animal));
            }
            for (Field fromSuperClass : fieldsFromSuperClass) {
                System.out.println(fromSuperClass.getName() + " " + fromSuperClass.get(animal));
            }
            try {
                Method method = animal.getClass().getMethod("makeSound");
                method.invoke(animal);
            } catch (NoSuchMethodException e) {
                System.out.println("Метод не найден");
            }
        }
    }
}